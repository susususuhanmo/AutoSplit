//package com.zstu.libdata.StreamSplit.bak
//
//import com.zstu.libdata.dataCleanTools.StreamCleanAndMatch.AuthorFunction.printLog.logUtil
//import com.zstu.libdata.dataCleanTools.StreamCleanAndMatch.StreamSplit.streamFunction._
//import org.apache.spark.rdd.RDD
//import org.apache.spark.sql.hive.HiveContext
//
///**
//  * Created by Administrator on 2017/6/9 0009.
//  */
//object DataOps {
////  joinedGroupedRdd: RDD[(String, Iterable[((String, String, String, String, String, String), Option[(String, String, String, String, String, String)])])],
////  fullInputRdd: RDD[(String, (String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String))],
////  sourceCoreRdd: RDD[(String, String)],
////  journalMagSourceRdd: RDD[(String, String)],
////  simplifiedJournalRdd: RDD[(String, (String, String, String, String, String, String))],
////  types: Int,
////  authorRdd: RDD[((String, String), String)],
////  CLCRdd: (RDD[(String, (String, String))]),
////  hiveContext: HiveContext
////  , forSplitRdd: RDD[(String, ((String, String), (String, String, String, String, String)))]
//def dealRdd(rdd: RDD[String],
//            simplifiedJournalRdd: RDD[(String, (String, String, String, String, String, String))],
//            journalMagSourceRdd: RDD[(String, String)],
//            sourceCoreRdd: RDD[(String, String)],
//            authorRdd: RDD[((String, String), String)],
//            clcRdd: (RDD[(String, (String, String))]),
//            types: Int,
//            hiveContext: HiveContext
//           ) ={
//
//  if(rdd.count() > 0) {
//
//    //简化后的输入Rdd
//    // (key, (title, journal, creator, id, institute))
//    val simplifiedInputRdd = getSimplifiedInputRdd(rdd, types)
//            logUtil("简化后的数据" + simplifiedInputRdd.count())
//
//    //待拆分数据
//    val forSplitRdd = getForSplitRdd(rdd, types)
//    logUtil("待拆分的数据" + forSplitRdd.count())
//
//    //完整输入Rdd
//    val fullInputRdd = getFullInputRdd(rdd, types)
//    logUtil("完整字段数据" + fullInputRdd.count())
//
//
//    //过滤出正常数据并将错误数据反馈
//    val rightInputRdd = getRightRddAndReportError(simplifiedInputRdd, hiveContext)
//    logUtil("正常数据" + rightInputRdd.count())
//
//    //开始查重 join group
//    val inputJoinJournalRdd = rightInputRdd.leftOuterJoin(simplifiedJournalRdd).map(f => (f._2._1._4, f._2))
//    logUtil("join成功" + inputJoinJournalRdd.count())
//    val joinedGroupedRdd = inputJoinJournalRdd.groupByKey()
//    logUtil("group成功" + joinedGroupedRdd.count())
//
//
//    //处理新数据 得到新的journal大表 和 新作者表
//    val (newSimplifiedJournalRdd, newAuthorRdd) =
//      dealNewData(joinedGroupedRdd, fullInputRdd, sourceCoreRdd
//        , journalMagSourceRdd, simplifiedJournalRdd, types
//        , authorRdd, clcRdd, hiveContext, forSplitRdd)
//    logUtil("新数据处理成功获得新数据")
//    logUtil("新作者数据" + newAuthorRdd.count())
//    logUtil("新journal数据" + newSimplifiedJournalRdd.count())
//
//    //将内存中的 Journal大表 和 作者表 更新为刚得到的新表。
////    simplifiedJournalRdd = newSimplifiedJournalRdd
////    authorRdd = newAuthorRdd
//    logUtil("数据更新成功")
//
//
//    //处理旧数据
//    dealOldData(inputJoinJournalRdd, fullInputRdd, sourceCoreRdd
//      , journalMagSourceRdd, simplifiedJournalRdd, types)
//    logUtil("匹配成功的旧数据处理成功")
//    (newSimplifiedJournalRdd, newAuthorRdd)
//  }
//  else{
//    logUtil("本批次数据数量为0")
//    (simplifiedJournalRdd, authorRdd)
//  }
//}
//}
