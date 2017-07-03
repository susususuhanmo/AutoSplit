//package com.zstu.libdata.StreamSplit.bak
//
//import com.zstu.libdata.StreamSplit.function.commonOps._
//import com.zstu.libdata.StreamSplit.function.distinctRdd.distinctInputRdd
//import com.zstu.libdata.StreamSplit.splitAuthor.getCLC.getCLCRdd
//import com.zstu.libdata.dataCleanTools.StreamCleanAndMatch.DataOpsFunction.CommonTools._
//import com.zstu.libdata.dataCleanTools.StreamCleanAndMatch.DataOpsFunction.ReadData.{readDataLog, readDataV3}
//import org.apache.spark.SparkConf
//import org.apache.spark.rdd.RDD
//import org.apache.spark.sql.DataFrame
//import org.apache.spark.sql.hive.HiveContext
//import org.apache.spark.streaming.dstream.DStream
//import org.apache.spark.streaming.kafka.KafkaUtils
//import org.apache.spark.streaming.{Seconds, StreamingContext}
//
//import scala.util.parsing.json.JSON
//
///**
//  * Created by Administrator on 2017/6/4 0004.
//  */
//object getDataBak {
//
//  /**
//    * 初始化Stream
//    *
//    * @param args          包含这四个参数<zkQuorum> <group> <topics> <numThreads>
//    * @param batchDuration 批处理时间（读取数据间隔时间）
//    * @return (hiveContext,receiveJsonStr,types) 返回hiveContext,接受数据Dtream,数据输入类型
//    */
//  def initStream(args: Array[String], batchDuration: Int): (HiveContext, DStream[String], Int, StreamingContext) = {
//    if (args.length < 4) {
//      System.err.println("Usage: KafkaWordCount <zkQuorum> <group> <topics> <numThreads>")
//      System.exit(1)
//    }
//    val Array(zkQuorum, group, topics, numThreads) = args
//    val conf = new SparkConf().setAppName("KafkaWordCount")
//    val ssc = new StreamingContext(conf, Seconds(batchDuration))
//    val hiveContext = new HiveContext(ssc.sparkContext)
//    val topicMap: Map[String, Int] = topics.split(",").map((_, numThreads.toInt)).toMap
//
//
//    val receiver = KafkaUtils.createStream(ssc, zkQuorum, group, topicMap)
//    val receiveJsonStr: DStream[String] = receiver.map(_._2)
//
//    //根据topic处理types
//    // 默认 1 ：cnki 2：wf 8：vip ：4
//    val types: Int = topics match {
//      case "viptest" =>
//        ssc.checkpoint("./Checkpoint_vip")
//        4
//      case "cnkitest" =>
//        ssc.checkpoint("./Checkpoint_cnki")
//        2
//      case "wftest" =>
//        ssc.checkpoint("./Checkpoint_wf")
//        8
//      case _ =>
//        ssc.checkpoint("./Checkpoint_vip")
//        4
//    }
//    (hiveContext, receiveJsonStr, types,ssc)
//  }
//
//
//  /**
//    * 读取所需数据
//    *
//    * @param hiveContext hiveContext
//    * @return (CLCRdd,authorRdd,simplifiedJournalRdd,sourceCoreRdd,journalMagSourceRdd)
//    *
//    */
//  def readSourceRdd(hiveContext: HiveContext) = {
//    val CLCRdd = getCLCRdd(hiveContext)
//    val authorRdd: RDD[((String, String), Any)] = readDataV3("t_Author_withSubjectAndKeyword_kid", hiveContext)
//      .map(row =>
//        ((row.getString(row.fieldIndex("name"))
//          , row.getString(row.fieldIndex("partOrgan"))),
//          (row.getString(row.fieldIndex("id")),
//            row.getString(row.fieldIndex("id")),
//              row.getString(row.fieldIndex("id")),
//                row.getString(row.fieldIndex("id"))
//          )
//          ))
//    val simplifiedJournalRdd = readDataLog("t_UnionResource2016", hiveContext)
//      .map(f => transformRdd(f))
//    val sourceCoreRdd = readDataLog("t_JournalCore", hiveContext)
//      .map(f => (f.getString(f.fieldIndex("name")), "1"))
//    val journalMagSourceRdd = readDataLog("t_JournalMag", hiveContext)
//      .map(f => (f.getString(f.fieldIndex("MAGTITLE")), f.getString(f.fieldIndex("DATASOURCE"))))
//    (CLCRdd, authorRdd, simplifiedJournalRdd, sourceCoreRdd, journalMagSourceRdd)
//  }
//
//
//  /**
//    * 解析Stream输入Json并去重，得到简化的Rdd
//    *
//    * @param rdd   kafka输入rdd
//    * @param types 数据来源
//    * @return
//    */
//  def getSimplifiedInputRddJSON(rdd: RDD[String], types: Int): RDD[(String, (String, String, String, String, String, String))] = distinctInputRdd(
//    rdd.map(jsonStr => {
//    val jsonSome = JSON.parseFull(jsonStr) //将JSON格式字符串解读成Some
//    jsonSome match {
//      case Some(jsonMap: Map[String, Any]) =>
//        if (types == 2) parseCnkiJson(jsonMap)
//        else if (types == 8) parseWfJson(jsonMap)
//        else parseVipJson(jsonMap)
//    }
//  })
//  )
//
//  /**
//    *
//    * @param data data
//    * @return
//    */
//  def getSimplifiedInputRdd(data: DataFrame) ={
//    //    (key, (title, journal, creator, id, institute,year))
//    //val key = cutStr(title, 6) + cutStr(journal, 4)
//    def getJournal(journal1: String,journal2: String) ={
//      if (journal1 == null || journal1 == "" ) {
//        journal2
//      }else journal1
//    }
//    distinctInputRdd(
//      data.map(r =>
//        (
//          cutStr(cnkiOps.cleanTitle(getRowString(r,"title")),6) + cutStr(getRowString(r,"journal"),4),
//          (cnkiOps.cleanTitle(getRowString(r,"title")),
//            cnkiOps.cleanJournal(getJournal(getRowString(r,"journal"),getRowString(r,"journal2"))),
//            cnkiOps.getFirstCreator(getRowString(r,"creator")),
//            getRowString(r,"GUID"),
//            cnkiOps.getFirstInstitute(getRowString(r,"institute")),
//            getRowString(r,"year")
//          )
//        ))
//    )
//  }
//  /**
//    * 获取为Split准备的数据
//    *
//    * @param rdd   kafka输入Rdd
//    * @param types 来源
//    * @return
//    */
//  def getForSplitRddStream(rdd: RDD[String], types: Int): RDD[(String, ((String, String), (String, String, String, String, String)))] = {
//
//    def cleanKeyword(keyword: String) = {
//      if(keyword == null) null
//      else keyword.replace("!|",";")
//    }
//    rdd.map(f = jsonStr => {
//      val jsonSome = JSON.parseFull(jsonStr) //将JSON格式字符串解读成Some
//      jsonSome match {
//        //null 处原为 jsonMap("keyword_alt") 由于输入数据没有此字段故删除
//        case Some(jsonMap: Map[String, String]) =>
//          if (types == 2) {
//            (jsonMap("guid"),
//              ((jsonMap("creator"), jsonMap("institute")),
//                (cleanKeyword(jsonMap("keyword")), null, jsonMap("subject"), jsonMap("id"), jsonMap("journal"))
//              ))
//          } else if (types == 8) {
//            (jsonMap("guid"),
//              ((jsonMap("creator"), jsonMap("institute")),
//                (cleanKeyword(jsonMap("keyword")), null, jsonMap("subject"), jsonMap("id"), jsonMap("journal"))
//              ))
//          } else {
//            (jsonMap("guid"),
//              ((jsonMap("creator"), jsonMap("institute")),
//                (cleanKeyword(jsonMap("keyword")), null, jsonMap("subject"), jsonMap("id"), jsonMap("journal"))
//              ))
//          }
//      }
//    })
//
//  }
//
//
//
//
//  def getForSplitRdd(data:DataFrame): RDD[(String, ((String, String), (String, String, String, String, String)))] = {
//    def cleanKeyword(keyword: String) = {
//      if(keyword == null) null
//      else keyword.replace("!|",";")
//    }
//    data.map(r =>(
//      getRowString(r,"GUID"),
//      ((getRowString(r,"creator"), getRowString(r,"institute")),
//        (cleanKeyword(getRowString(r,"keyword")), null,
//          getRowString(r,"subject"), getRowString(r,"GUID"),
//          getRowString(r,"journal"))
//      )
//    ))
//  }
//
//
//  /**
//    * 解析Stream输入Json，得到完整的Rdd
//    *
//    * @param rdd   kafka输入Rdd
//    * @param types 来源
//    * @return
//    */
//  def getFullInputRddStream(rdd: RDD[String], types: Int): RDD[(String, (String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String))] = {
//    rdd.map(sourceStr => {
//      val jsonSome = JSON.parseFull(sourceStr) //将JSON格式字符串解读成Some
//      jsonSome match {
//        case Some(jsonMap: Map[String, Any]) =>
//          if (types == 2) {
//            parseCnkiSourceJson(jsonMap)
//          } else if (types == 8) {
//            parseWfSourceJson(jsonMap)
//          } else {
//            parseVipSourceJson(jsonMap)
//          }
//      }
//    })
//  }
//
//
//  def getFullInputRdd(data:DataFrame): RDD[(String, (String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String))] = {
////    (id, (id, title, titleAlt, creator, creatorAlt, creatorAll, keyWord, keyWordAlt, institute, instituteAll, year, journal, issue, url,abstractcont,abstractcont_alt))
////    getRowString(r,"title")
//    data.map(r=>
//      (
//        getRowString(r,"GUID"),(
//        getRowString(r,"GUID"),
//        getRowString(r,"title"),
//        /*getRowString(r,"titleAlt")*/null,
//        getRowString(r,"creator"),
//       /* getRowString(r,"creatorAlt")*/null,
//        getRowString(r,"creator_all"),
//        getRowString(r,"keyword"),
//        /*getRowString(r,"keyWordAlt")*/null,
//        getRowString(r,"institute"),
//        /*getRowString(r,"instituteAll")*/null,
//        getRowString(r,"year"),
//        getRowString(r,"journal"),
//        getRowString(r,"issue"),
//        getRowString(r,"url"),
//       /* getRowString(r,"abstractcont")*/null,
//        /*getRowString(r,"abstractcont_alt")*/null))
//    )
//  }
//
//
//
//
//
//  /**
//    * 将错误信息写入t_error,返回正确数据
//    *
//    * @param simplifiedInputRdd 简化过的输入数据
//    * @param hiveContext        hiveContext
//    * @return rightRdd
//    */
//  def getRightRddAndReportError(simplifiedInputRdd: RDD[(String, (String, String, String, String, String, String))], hiveContext: HiveContext): RDD[(String, (String, String, String, String, String, String))] = {
//    //errorRDD也是一个集合，存放streamingRDD中的错误数据
//    val (errorRDD, rightRdd) = (simplifiedInputRdd.filter(f => {
//      commonOpsBak.filterErrorRecord(f._2)
//    })
//      , simplifiedInputRdd.filter(f => commonOpsBak.filterTargetRecord(f._2)))
//    //把errorRDD集合映射成t_error表（sqlserver）中的字段
//    val writeErrorRDD = errorRDD.map(f => (f._2._4, f._2.toString()))
//    if (writeErrorRDD.count() > 0) {
//      commonOpsBak.insertData("t_Error", hiveContext, writeErrorRDD)
//    }
//
//    rightRdd
//  }
//}
