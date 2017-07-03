//package com.zstu.libdata.StreamSplit.bak
//
//import com.zstu.libdata.StreamSplit.function.getData._
//import com.zstu.libdata.dataCleanTools.StreamCleanAndMatch.AuthorFunction.printLog._
//
//
///**
//  * Created by Administrator on 2017/6/4 0004.
//  */
//object mainStream {
//
//
//  def main(args: Array[String]): Unit = {
//
//    //根据输入到args中的zkQuorum, group, topics, numThreads参数初始化Stream
//
//    val (hiveContext, receiveJsonStr, types, ssc) = initStream(args, batchDuration = 300)
//
//    logUtil("stream初始化完成")
//
//    //读取所需表：作者表 clc对照表,journal表 core表 Mag表
//    var (clcRdd, authorRdd, simplifiedJournalRdd, sourceCoreRdd, journalMagSourceRdd)
//    = readSourceRdd(hiveContext)
//    logUtil("数据读取完成")
//    logUtil("clc" + clcRdd.count())
//    logUtil("author" + authorRdd.count())
//    logUtil("simpified" + simplifiedJournalRdd.count())
//    logUtil("sourceCore" + sourceCoreRdd.count())
//    logUtil("Mag" + journalMagSourceRdd.count())
//
//
//    //对输入数据进行处理
//    receiveJsonStr.foreachRDD(rdd => {
//      try {
//        if (rdd.count() > 0) {
//          logUtil("开始处理kafka数据")
//          //简化后的输入Rdd
//          // (key, (title, journal, creator, id, institute))
//          val simplifiedInputRdd = getSimplifiedInputRddJSON(rdd, types)
//          logUtil("简化后的数据" + simplifiedInputRdd.count())
//
//          //待拆分数据
//          val forSplitRdd = getForSplitRddStream(rdd, types)
//          logUtil("待拆分的数据" + forSplitRdd.count())
//
//
//          //完整输入Rdd
//          val fullInputRdd = getFullInputRddStream(rdd, types)
//          logUtil("完整字段数据" + fullInputRdd.count())
//
//
//          //过滤出正常数据并将错误数据反馈
//          val rightInputRdd = getRightRddAndReportError(simplifiedInputRdd, hiveContext)
//          logUtil("正常数据" + rightInputRdd.count())
//
//          //开始查重 join group
//          val inputJoinJournalRdd = rightInputRdd.leftOuterJoin(simplifiedJournalRdd).map(f => (f._2._1._4, f._2))
//          logUtil("join成功" + inputJoinJournalRdd.count())
//          val joinedGroupedRdd = inputJoinJournalRdd.groupByKey()
//          logUtil("group成功" + joinedGroupedRdd.count())
//
//
//          //处理新数据 得到新的journal大表 和 新作者表
//          val (newSimplifiedJournalRdd, newAuthorRdd) =
//            dealNewData(joinedGroupedRdd, fullInputRdd, sourceCoreRdd
//              , journalMagSourceRdd, simplifiedJournalRdd, types
//              , authorRdd, clcRdd, hiveContext, forSplitRdd)
//          logUtil("新数据处理成功获得新数据")
//          logUtil("新作者数据" + newAuthorRdd.count())
//          logUtil("新journal数据" + newSimplifiedJournalRdd.count())
//
//          //将内存中的 Journal大表 和 作者表 更新为刚得到的新表。
//          simplifiedJournalRdd = newSimplifiedJournalRdd
//          authorRdd = newAuthorRdd
//          logUtil("数据更新成功")
//
//
//          //处理旧数据
//          val num = dealOldData(inputJoinJournalRdd, fullInputRdd, sourceCoreRdd
//            , journalMagSourceRdd, simplifiedJournalRdd, types)
//          logUtil("匹配成功的旧数据处理成功" + num)
//        }
//        else logUtil("本批次数据数量为0")
//      }
//      catch {
//        case ex: Exception => logUtil(ex.getMessage)
//      }
//    })
//
//    ssc.start()
//    logUtil("start!")
//    ssc.awaitTermination()
//  }
//
//}
