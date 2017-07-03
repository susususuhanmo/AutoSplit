//package com.zstu.libdata.dataCleanTools.StreamCleanAndMatch.StreamSplit.test
//
//import java.io.PrintWriter
//import java.sql.{Connection, DriverManager, PreparedStatement}
//
//import com.zstu.libdata.kafka.commonClean
//import org.apache.spark.SparkConf
//import org.apache.spark.rdd.RDD
//import org.apache.spark.sql.hive.HiveContext
//import org.apache.spark.streaming.dstream.DStream
//import org.apache.spark.streaming.kafka.KafkaUtils
//import org.apache.spark.streaming.{Seconds, StreamingContext}
//import org.joda.time.DateTime
//
//import scala.util.parsing.json.JSON
//
///**
//  * Created by Administrator on 2017/6/3 0003.
//  */
//object streamcopy  {
//
//  val conf = new SparkConf()
//    .setAppName("DataClean")
//  var logger = new PrintWriter("./StreamingLog.log")
//
//  def logUtil(info: String): Unit = {
//    if (logger != null) {
//      logger.println(info + "\r\n")
//      logger.flush()
//    }
//  }
//
//  def getrdd_kafka_simplify (rdd:RDD[String],types:Int)={
//    rdd.map(jsonStr => {
//      val jsonSome = JSON.parseFull(jsonStr) //将JSON格式字符串解读成Some
//      jsonSome match {
//        case Some(jsonMap: Map[String, Any]) => {
//          if (types == 2) {
//            commonClean.parseCnkiJson(jsonMap)
//          } else if (types == 8) {
//            commonClean.parseWfJson(jsonMap)
//          } else {
//            commonClean.parseVipJson(jsonMap)
//          }
//        }
//      }
//    })
//
//  }
//
//  def getrdd_kafka_source(rdd:RDD[String],types:Int)={
//    rdd.map(sourceStr => {
//      val jsonSome = JSON.parseFull(sourceStr) //将JSON格式字符串解读成Some
//      jsonSome match {
//        case Some(jsonMap: Map[String, Any]) => {
//          if (types == 2) {
//            commonClean.parseCnkiSourceJson(jsonMap)
//          } else if (types == 8) {
//            commonClean.parseWfSourceJson(jsonMap)
//          } else {
//            commonClean.parseVipSourceJson(jsonMap)
//          }
//        }
//      }
//    })
//  }
//
//
//
//
//
//
//
//  def main(args: Array[String]): Unit = {
//    if (args.length < 4) {
//      System.err.println("Usage: KafkaWordCount <zkQuorum> <group> <topics> <numThreads>")
//      System.exit(1)
//    }
//
//    /****************根据输入topic分类*******************/
//    val Array(zkQuorum, group, topics, numThreads) = args
//    var types = 4 // 默认 1 ：cnki 2：wf 8：vip ：4
//    if(topics.equals("test3")){
//      logger = new PrintWriter("./vipScala.log")
//      types = 4
//    }
//    if (topics.equals("test")) {
//      logger = new PrintWriter("./cnkiScala.log")
//      types = 2
//    }
//    if (topics.equals("test2")){
//      logger = new PrintWriter("./wfScala.log")
//      types = 8
//    }
//    logUtil("------------开始运行-------------")
//    val ssc = new StreamingContext(conf, Seconds(60))
//    if(types ==2){
//      ssc.checkpoint("./Checkpoint_cnki")
//    }else if(types == 4){
//      ssc.checkpoint("./Checkpoint_vip")
//    }else if(types ==8) {
//      ssc.checkpoint("./Checkpoint_wf")
//    }
//    val hiveContext = new HiveContext(ssc.sparkContext)
//
//
//    /***************读取t_journal2016_standard，t_JournalCore，t_JournalMag表*****/
//    val journalData = commonClean.readData("t_journal2016_standard", hiveContext)
//    //journal数据，  样例：(事业单位财务经营管理,(事业单位财务管理问题研究及对策,经营管理者,徐敏慧,A5DF06EB-330E-E711-AC60-D8D385F7104F))
//    var  simplifiedJournalRdd = journalData.map(f => commonClean.transformRdd(f))
//    logUtil("------------当前t_Journal2016数量为：" + simplifiedJournalRdd.count() + "---------------")
//    logUtil("------------journal2016样例：" + simplifiedJournalRdd.first().toString() + "---------------")
//    val coreData = commonClean.readData("t_JournalCore", hiveContext)
//    //corejournal， 样例： (actabiochimicaetbiophysicasinica,1)
//    val  sourceCoreRdd = coreData.map(f => (f.getString(f.fieldIndex("name")), "1"))
//    //读取journalmag
//    val journalMag = commonClean.readData("t_JournalMag",hiveContext)
//    val journalMagSourceRdd = journalMag.map(f=>(f.getString(f.fieldIndex("MAGTITLE")),f.getString(f.fieldIndex("DATASOURCE"))))
//    logUtil("-------------当前_journalmag的数量为：--------" + journalMagSourceRdd.count() + "-------------")
//    logUtil("------------rdd_sql_journalmag_source样例：" + journalMagSourceRdd.first().toString() + "---------------")
//
//
//
//
//    /****************获取stream数据****************/
//    val topicMap: Map[String, Int] = topics.split(",").map((_, numThreads.toInt)).toMap
//    val receiver = KafkaUtils.createStream(ssc, zkQuorum, group, topicMap)
//    val rdd_kafka_receivejson: DStream[String] = receiver.map(_._2)
//
//
//
//
//
//
//
//    /****************处理数据：foreachRDD开始*******************/
//    rdd_kafka_receivejson.foreachRDD(rdd => {
//      logUtil("-----本批次的RDD数据量为:-----" + rdd.count() + "------")
//
//
//
//
//      //格式： {"year":"2016","code":"669237585","url":"http:\/\/lib.cqvip.com\/qk\/94206X\/201606\/669237585.html","catalog":"\u4e2d\u6587\………………}
//      try {
//
//        //将kafka读入的数据标准化为：  (key, (title, journal, creator, id, institute))
//        //样例数据：(东堂变35 湖南电力,(东堂变35 KV母线短路故障原因分析,湖南 电力,唐军|!段明才|!周宇|!何昌雄,841F706D-482A-E711-AECF-0050569B7A51,国网湖南省电力公司郴州供电公司))
//        val simplifiedInputRdd = getrdd_kafka_simplify(rdd,types)
//        logUtil("------------rdd_kafka_simplify：" + simplifiedInputRdd.first().toString() + "---------------")
//
//
//
//
//        //这里的数据都是经过清洗之后的
//        // data 28   （id，6）（id,22）
//        //从kafka读入数据的完整格式
//        //样例数据： (841F706D-482A-E711-AECF-0050569B7A51,(841F706D-482A-E711-AECF-0050569B7A51,东堂变35 KV母线短路故障原因分析,,唐军[1] ,,唐军[1] ;;;段明才[1] ;;;周宇[2] ;;;何昌雄[1],35;kV母线;复合套管;污闪;母差保护;弧光接地过电压;中性点不接地;击穿;两相接 地短路,,国网湖南省电力公司郴州供电公司,,2016,湖南电力,2016年第36卷第4期 55-58页,共4页,http://lib.cqvip.com/qk/92072A/201604/669830896.html))
//        val  fullInputRdd = getrdd_kafka_source(rdd,types)
//        logUtil("------------rdd_kafka_source：" + fullInputRdd.first().toString() + "---------------")
//
//
//
//
//
//
//
//
//
//        //errorRDD也是一个集合，存放streamingRDD中的错误数据
//        val errorRDD = simplifiedInputRdd.filter(f => {commonClean.filterErrorRecord(f._2)})
//
//        //把errorRDD集合映射成t_error表（sqlserver）中的字段
//        val writeErrorRDD = errorRDD.map(f => (f._2._4, f._2.toString()))
//        if (writeErrorRDD.count() > 0) {
//          logUtil("---------将title,journal为空的数据放入错误表--------------")
//          commonClean.insertData("t_Error", hiveContext, writeErrorRDD)
//          logUtil("---------当前批次共有" + errorRDD.count() + "条错误,已经写入-----------")
//        }
//
//
//        //targetRDD一个集合，存放streamingRDD的正确数据
//        val  rightInputRdd = simplifiedInputRdd.filter(f => commonClean.filterTargetRecord(f._2))
//
//
//
//
//        logUtil("------------join开始---" + DateTime.now + "-----------------------rdd_kafka_simplify_afterdataclean---" + rightInputRdd.count() + "--------")
//        //将kafka数据和数据库读取数据journal2016（都已经转化成相同格式的key,value）
//        //target：(key,(kafka1,kafka2,kafka3))
//        // journal2016：（key,(1,2,3)）
//        //              （key,(4,5,6)）
//        // join：（key,（（kafka1,kafka2,kafka3）,（1，2，3）））
//        //       （key,（（kafka1,kafka2,kafka3）,（4，5，6）））
//        //样例：(把纪律和规矩资源导刊,((把纪律和规矩挺在前面——浅谈践行监督执纪“四种形态”的几点认识,资源导刊,王丽,0C0D95A8-4B2A-E711-AECF-0050569B7A51,濮阳市国土资源局),None))
//        val inputJoinJournalRdd = rightInputRdd.leftOuterJoin(simplifiedJournalRdd) //
//        logUtil("------------join结束---" + DateTime.now + "---------------------------------count---" + inputJoinJournalRdd.count() + "--------")
//
//
//
//
//
//        logUtil("------------开始进行查重---------------" + DateTime.now + "----------------------- ")
//        //样例：-(71841F5A-B42C-E711-AECF-0050569B7A51,((后路辅助寰椎椎弓根螺钉置钉技术 的研究进展,中国矫形外科杂志,董春科|!李配瑶|!谭明生|!姜良海,71841F5A-B42C-E711-AECF-0050569B7A51,北京中医药大学基础医学院,北京100029),Some((后路辅助寰椎椎弓根螺钉置 钉技术的研究进展,中国矫形外科杂志,董春科,2D81F4EA-330E-E711-AC60-D8D385F7104F))))
//        val  inputJoinJournalRdd = inputJoinJournalRdd.map(f => (f._2._1._4, f._2)) //重新映射，把guid作为key
//        logUtil("---rdd_join_kafka2journal2016_map---" + inputJoinJournalRdd.first().toString() + "---" + inputJoinJournalRdd.count() + "---")
//        val joinedGroupedRdd = inputJoinJournalRdd.groupByKey()
//
//
//
//
//
//        /******** 相似度小于90的处理开始 *******/
//        //样例：(1EC27D90-4B2A-E711-AECF-0050569B7A51,(手机软件增添学中文乐 趣系统教学仍不可或缺,海外华文教育动态,,1EC27D90-4B2A-E711-AECF-0050569B7A51,))
//        val  rdd_kafka_result_notmatch = joinedGroupedRdd
//          .filter(f => commonClean.filterDisMatchData(f._2))
//          .map(f => (f._1, f._2.take(1).toList.apply(0)._1))
//        //入库(完整字段）
//        if(rdd_kafka_result_notmatch.first()!=null){
//          //样例：(ECB71BCD-B42C-E711-AECF-0050569B7A51,((ECB71BCD-B42C-E711-AECF-0050569B7A51,经皮椎间孔镜下髓核摘除术治疗老年腰椎间盘突出症的 疗效分析,,郑振阳|!孙兆忠|!郑建民|!石琪|!李瑞,,郑振阳|!孙兆忠|!郑建民|!石琪|!李瑞, 腰椎间盘突出症;椎间孔镜;髓核摘除术;高龄,@@,,,2016,ISTICPKU,2016, 24(23),http://d.wanfangdata.com.cn/Periodical_zgjxwkzz201623016.aspx),(经皮椎间孔镜下髓核摘除术治疗老年腰椎间盘突出症的疗效分析,中国矫形外科杂志,郑振阳|!孙兆忠|!郑建民|!石琪|!李瑞,ECB71BCD-B42C-E711-AECF-0050569B7A51,)))
//          val rdd_kafka_newdata_source = fullInputRdd.join(rdd_kafka_result_notmatch).distinct()
//          logUtil("----获取到需要插入的数据总数为--------count---" + rdd_kafka_newdata_source.count() + "--------")
//          logUtil("------------rdd_kafka_newdata_source：" + rdd_kafka_newdata_source.first().toString() + "---------------")
//          logUtil("-----现在开始进行新数据的insert操作-----")
//
//          //样例：(ISTICPKU,(ECB71BCD-B42C-E711-AECF-0050569B7A51,经皮椎间孔镜下髓核摘除术治疗老年腰椎间盘突出症的疗效分析,,郑振阳|!孙兆忠|!郑建民|!石琪|!李瑞,,郑振阳|!孙兆忠|!郑建民|!石琪|!李瑞,腰椎间盘突出症;椎间孔镜;髓核摘除术;高龄,@@,,,2016,ISTICPKU,2016, 24(23),http://d.wanfangdata.com.cn/Periodical_zgjxwkzz201623016.aspx,(经皮椎间孔镜下髓核摘除术治疗老年腰椎间盘突出症的疗效分析,中国矫形外科杂志,郑振阳|!孙兆忠|!郑建民|!石琪|!李瑞,ECB71BCD-B42C-E711-AECF-0050569B7A51,)))
//          val rdd_kafka__newdata_source_insert_map = rdd_kafka_newdata_source.map(f => (f._2._1._12, (f._2._1._1, f._2._1._2, f._2._1._3, f._2._1._4, f._2._1._5, f._2._1._6, f._2._1._7, f._2._1._8, f._2._1._9, f._2._1._10, f._2._1._11, f._2._1._12, f._2._1._13, f._2._1._14, f._2._1._15,f._2._1._16,f._2._2)))
//          logUtil("------------rdd_kafka__newdata_source_insert_map：" + rdd_kafka__newdata_source_insert_map.first().toString() + "---------------")
//          //样例：(ISTICPKU,((ECB71BCD-B42C-E711-AECF-0050569B7A51,经皮椎间孔镜下髓核摘除术治疗老年腰椎间盘突出症的疗效分析,,郑振阳|!孙兆忠|!郑建民|!石琪|!李瑞,,郑振阳|!孙兆忠|!郑建民|!石琪|!李瑞,腰椎间盘突出症;椎 间孔镜;髓核摘除术;高龄,@@,,,2016,ISTICPKU,2016, 24(23),http://d.wanfangdata.com.cn/Periodical_zgjxwkzz201623016.aspx,(经皮椎间孔镜下髓核摘除术治疗老年腰椎间盘突出症的疗效分析,中国矫形外科杂志,郑振阳|!孙兆忠|!郑建民|!石琪|!李瑞,ECB71BCD-B42C-E711-AECF-0050569B7A51,)),None))
//          val rdd_kafka_newdata_source_imsert_map2 = rdd_kafka__newdata_source_insert_map.leftOuterJoin(sourceCoreRdd)
//          logUtil("------------rdd_kafka_newdata_source_imsert_map2：" + rdd_kafka_newdata_source_imsert_map2.first().toString() + "---------------")
//          //样例：(ISTICPKU,(((ECB71BCD-B42C-E711-AECF-0050569B7A51,经皮椎间孔镜下髓核摘除术治疗老年腰椎间盘突出症的疗效分析,,郑振阳|!孙兆忠|!郑建民|!石琪|!李瑞,,郑振阳|!孙兆忠|!郑建民|!石琪|!李瑞,腰椎间盘突出症;椎间孔镜;髓核摘除术;高龄,@@,,,2016,ISTICPKU,2016, 24(23),http://d.wanfangdata.com.cn/Periodical_zgjxwkzz201623016.aspx,(经皮椎间孔镜下髓核摘除术治疗老年腰椎间盘突出症的疗效分析,中国矫形外科杂志,郑振阳|!孙兆忠|!郑建民|!石琪|!李瑞,ECB71BCD-B42C-E711-AECF-0050569B7A51,)),None),None))
//          val rdd_kafka_newdata_source_imsert_map3 = rdd_kafka_newdata_source_imsert_map2.leftOuterJoin(journalMagSourceRdd)
//          logUtil("------------rdd_kafka_newdata_source_imsert_map3：" + rdd_kafka_newdata_source_imsert_map3.first().toString() + "---------------")
//          //样例：(F2BB2E10-4C2A-E711-AECF-0050569B7A51,第33届国际地理大会在京圆满闭幕,,,,,中国地理学会;国际;中国科学院;地理科学;科学技术;资源,,,,2016,资源导刊,2016年第0卷第15期 5-5页,共1页,http://lib.cqvip.com/qk/96616B/201615/670472909.html,0,1,第33届国际地理大会在京圆满闭幕)-
//          val rdd_kafka__newdata_source_insert_final = rdd_kafka_newdata_source_imsert_map3.map(f => {
//            var iscore = 0
//            var journaldatasource = ""
//            if (f._2._1._2 == None)
//              iscore = 0
//            else
//              iscore = 1
//            if(f._2._2 == None)
//              journaldatasource = ""
//            else
//              journaldatasource =f._2._2.get
//            (f._2._1._1._1, f._2._1._1._2, f._2._1._1._3, f._2._1._1._4, f._2._1._1._5, f._2._1._1._6, f._2._1._1._7, f._2._1._1._8, f._2._1._1._9, f._2._1._1._10, f._2._1._1._11, f._2._1._1._12, f._2._1._1._13, f._2._1._1._14, iscore, 1, "",journaldatasource, f._2._1._1._15, f._2._1._1._16)
//          })
//          logUtil("------------rdd_kafka__newdata_source_insert_final：" + rdd_kafka__newdata_source_insert_final.first().toString() + "---------------")
//
//          //把新增的数据，加入到原始的journal2016的rdd中。后面再有同个数据则不再被认为是新增数据
//          val rdd_kafka_newdata_source_insert_to_memory =rdd_kafka__newdata_source_insert_final.map(f=>(commonClean.getJournalKay(f._2,f._12),(f._2,f._12,f._4,f._1,f._9,f._11)))
//          logUtil("------------rdd_sql_journal2016_simplify,before：union" + simplifiedJournalRdd.count() + "---------------")
//          simplifiedJournalRdd = simplifiedJournalRdd.union(rdd_kafka_newdata_source_insert_to_memory)
//          logUtil("------------rdd_sql_journal2016_simplify,after union：" + simplifiedJournalRdd.count() + "---------------")
//          logUtil("------------rdd_kafka_newdata_source_insert_to_memory：" + rdd_kafka_newdata_source_insert_to_memory.first().toString() + "---------------")
//
//          rdd_kafka__newdata_source_insert_final.foreach(f => {
//            var conn: Connection = null
//            var stmt: PreparedStatement = null
//            try {
//              conn = DriverManager.getConnection(commonClean.sqlUrl, commonClean.userName, commonClean.passWord);
//              val insertSQL = "insert into t_JournalLog(id,title,titleAlt,creator,creatorAlt,creatorAll,keyword,keywordAlt,institute,instituteAll,year,journal,issue,url,isCore,operater,operateTime,source,isCheck,otherId,volume,page,datasource,abstract,abstractAlt)" +
//                "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,getdate(),"+types+",0,?,?,?,?,?,?)"
//              stmt = conn.prepareStatement(insertSQL)
//              commonClean.setData4newdata(stmt, f, types)
//              stmt.execute()
//              //新增数据插入原表 journal2016 ()
//              //              val insertSQL_journal2016 = "insert into t_Journal2016_standard (id,title,titleAlt,authorName,authorName1,allAuthors,keywords,keywordAlt,orgName,allOrgans,year,journal,issue,defaultUrl,isCore,volume,pages,abstract,abstractAlt) "+
//              //                                                                      "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
//              //              stmt = conn.prepareStatement(insertSQL_journal2016)
//              //              commonClean.setData4newdata2Journal2016(stmt, f, types)
//              //              stmt.execute()
//            } catch {
//              case ex: Exception => logUtil("---插入数据库的时候出现错误，错误原因为---" + ex.getMessage)
//                logUtil("-------错误数据---" + f.toString())
//            } finally {
//              if (stmt != null) stmt.close()
//              if (conn != null) conn.close()
//            }
//          })
//        }
//        logUtil("---------新数据  insert操作完成---------")
//
//        /******** 相似度小于90的处理结束 *******/
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//             /******** 相似度大于90的处理开始 *******/
//        val rdd_kafka_result_match = inputJoinJournalRdd.filter(f => commonClean.getDisMatchRecord(f._2)).groupByKey().map(f => commonClean.getHightestRecord(f))
//        logUtil("------------查重结束---------------" + DateTime.now + "---------------------matchedCount-- " + rdd_kafka_result_notmatch.count() + "--------")
//
//        //将disMatchResult入库
//        if (rdd_kafka_result_match.first() != null) {
//          logUtil("-------查找到数据盘匹配度大于0.9的数据，现在进行insert操作-----理论上需要插入的数据总数为：-" + rdd_kafka_result_match.count() + "----")
//          val rdd_kafka_matchdata_source = fullInputRdd.join(rdd_kafka_result_match).distinct()
//          logUtil("------------rdd_kafka_matchdata_source：" + rdd_kafka_matchdata_source.first().toString() + "---------------")
//          logUtil("----获取到需要插入的数据总数为--------count---" + rdd_kafka_matchdata_source.count() + "--------")
//          logUtil("-----现在开始进行insert操作-----")
//          val  rdd_kafka_matchdata_source_insert_map = rdd_kafka_matchdata_source.map(f => (f._2._1._12, (f._2._1._1, f._2._1._2, f._2._1._3, f._2._1._4, f._2._1._5, f._2._1._6, f._2._1._7, f._2._1._8, f._2._1._9, f._2._1._10, f._2._1._11, f._2._1._12, f._2._1._13, f._2._1._14, f._2._1._15,f._2._1._16, f._2._2)))
//          logUtil("------------rdd_kafka_matchdata_source_insert_map：" + rdd_kafka_matchdata_source_insert_map.first().toString() + "---------------")
//          val rdd_kafka_matchdata_source_insert_map2 =  rdd_kafka_matchdata_source_insert_map.leftOuterJoin(sourceCoreRdd)
//          logUtil("------------rdd_kafka_matchdata_source_insert_map2：" + rdd_kafka_matchdata_source_insert_map2.first().toString() + "---------------")
//          val rdd_kafka_matchdata_source_insert_map3 =  rdd_kafka_matchdata_source_insert_map2.leftOuterJoin(journalMagSourceRdd)
//          logUtil("------------rdd_kafka_matchdata_source_insert_map3：" + rdd_kafka_matchdata_source_insert_map3.first().toString() + "---------------")
//          val rdd_kafka_matchdata_source_insert_final =rdd_kafka_matchdata_source_insert_map3.map(f => {
//            var iscore = 0
//            var journaldatasource = ""
//
//            if (f._2._1._2.isEmpty)
//              iscore = 0
//            else
//              iscore = 1
//            if(f._2._2.isEmpty)
//              journaldatasource = ""
//            else
//              journaldatasource =f._2._2.get
//            (f._2._1._1._1, f._2._1._1._2, f._2._1._1._3, f._2._1._1._4, f._2._1._1._5, f._2._1._1._6, f._2._1._1._7, f._2._1._1._8, f._2._1._1._9, f._2._1._1._10, f._2._1._1._11, f._2._1._1._12, f._2._1._1._13, f._2._1._1._14, iscore, 2, f._2._1._1._15,journaldatasource, f._2._1._1._15, f._2._1._1._16, f._2._1._1._17)
//          })
//          logUtil("------------rdd_kafka_matchdata_source_insert_final：" + rdd_kafka_matchdata_source_insert_final.first().toString() + "---------------")
//          rdd_kafka_matchdata_source_insert_final.foreach(f => {
//            var conn: Connection = null
//            var stmt: PreparedStatement = null
//            try {
//              conn = DriverManager.getConnection(commonClean.sqlUrl, commonClean.userName, commonClean.passWord);
//              val insertSQL = "insert into t_JournalLog(id,title,titleAlt,creator,creatorAlt,creatorAll,keyword,keywordAlt,institute,instituteAll,year,journal,issue,url,isCore,operater,operateTime,source,isCheck,otherId,volume,page,datasource,abstract,abstractAlt)" +
//                "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,getdate(),"+types+",0,?,?,?,?,?,?)"
//              stmt = conn.prepareStatement(insertSQL)
//              commonClean.setData(stmt, f, types)
//              if(f._1  != f._21) //id  == otherid 表示该数据重复，不保存
//                stmt.execute()
//            } catch {
//              case ex: Exception => logUtil("---插入数据库的时候出现错误，错误原因为---" + ex.getMessage)
//                logUtil("-------错误数据---" + f.toString())
//            } finally {
//              if (stmt != null) stmt.close()
//              if (conn != null) conn.close()
//            }
//          })
//        }
//        /******** 相似度大于90的处理结束 *******/
//
//
//
//
//
//
//
//
//
//
//        //todo 一下部分可能是作者匹配，用我的函数代替
//
//        //rdd_kafka_result_notmatch的进一步处理
//        // 转换RDD的格式(期刊名,作者,id,机构)
//        if (rdd_kafka_result_notmatch.first() != null) {
//          //如果第一行是null，说明是空，不进行下面操作
//          val coreJoinRDD = rdd_kafka_result_notmatch.map(f => (f._2._2, (f._2._3, f._2._4, f._2._5)))
//          logUtil("------------现在匹配核心期刊名:-----------------" + DateTime.now + "--------------------count-" + coreJoinRDD.count() + "-------")
//          val coreResult = coreJoinRDD.leftOuterJoin(sourceCoreRdd)
//          //coreSourceRDD为非核心期刊数据，直接插入元数据表
//          val coreSourceRDD = coreResult.filter(row => commonClean.sourceCoreRecord(row))
//          logUtil("--------开始将不是核心期刊的数据插入到元数据表t_Journal2016--------")
//          if (coreSourceRDD.count() > 0) {
//            //这里进行insert操作
//            logUtil("-------非核心期刊名的记录------count---" + coreSourceRDD.count() + "-------")
//          }
//          //coreFinalRDD为核心期刊表，
//          val coreFinalRDD = coreResult.filter(row => commonClean.matchCoreJournal(row))
//          logUtil("------------匹配核心期刊名结束:-----------------" + DateTime.now + "----------------coreCount:-----" + coreFinalRDD.count() + "----")
//          if (coreFinalRDD.count() > 0) {
//            val versionAuthor = commonClean.readData("version2_Author", hiveContext);
//            //读取作者机构表？？？sqlserver中该表不存在了
//            val authorRDD = versionAuthor.map(f => commonClean.getMatchMap(f))
//            //(作者+机构 ，id)
//            val coreMathchRDD = coreFinalRDD.map(f => {
//              val author = f._2._1._1
//              val instute = f._2._1._3
//              val key = author + instute
//              (key, f._2._1._2)
//            })
//            logUtil("-----开始进行作者匹配-----" + DateTime.now + "--------")
//            val result = coreMathchRDD.leftOuterJoin(authorRDD);
//            logUtil("------作者匹配结束------" + DateTime.now + "--------count-" + result.count())
//            //这是没有的数据，直接insert进数据库
//            val newData = result.filter(f => commonClean.dealDate(f))
//            val oldData = result.filter(f => commonClean.dealOldData(f))
//            newData.foreach(f => logUtil("---新数据的ID为:----" + f._2._1))
//            oldData.foreach(f => logUtil("---旧数据的Id为:----" + f._2._1))
//          }
//        }
//
//
//
//
//
//
//
//
//
//      } catch {
//        case ex: Exception => logUtil(ex.getMessage)
//      }
//    })
//    /****************处理完成：foreachRDD结束*******************/
//
//    ssc.start()
//    ssc.awaitTermination()
//  }
//}
