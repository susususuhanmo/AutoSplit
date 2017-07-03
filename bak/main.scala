//package com.zstu.libdata.StreamSplit.bak
//
//import com.zstu.libdata.dataCleanTools.StreamCleanAndMatch.AuthorFunction.printLog._
//import com.zstu.libdata.dataCleanTools.StreamCleanAndMatch.StreamSplit.streamFunction._
//import org.apache.spark.SparkConf
//import org.apache.spark.sql.hive.HiveContext
//import org.apache.spark.streaming.dstream.DStream
//import org.apache.spark.streaming.kafka.KafkaUtils
//import org.apache.spark.streaming.{Seconds, StreamingContext}
//
///**
//  * Created by Administrator on 2017/6/4 0004.
//  */
//object main {
//
//
//  def main(args: Array[String]): Unit = {
//
//    //根据输入到args中的zkQuorum, group, topics, numThreads参数初始化Stream
//
////    val (hiveContext, receiveJsonStr, types,ssc) = initStream(args, batchDuration = 300)
//
//
//
//
//
//    if (args.length < 4) {
//      System.err.println("Usage: KafkaWordCount <zkQuorum> <group> <topics> <numThreads>")
//      System.exit(1)
//    }
//    val Array(zkQuorum, group, topics, numThreads) = args
//    val conf = new SparkConf().setAppName("KafkaWordCount")
//    val ssc = new StreamingContext(conf, Seconds(60))
//    val hiveContext = new HiveContext(ssc.sparkContext)
//    val topicMap: Map[String, Int] = topics.split(",").map((_, numThreads.toInt)).toMap
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
//
//
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
//
//
//    //对输入数据进行处理
//    receiveJsonStr.foreachRDD(rdd => {
//      logUtil("开始处理kafka数据000")
//      val  (newSimplifiedJournalRdd, newAuthorRdd) = DataOps.dealRdd(rdd,simplifiedJournalRdd,journalMagSourceRdd,
//        sourceCoreRdd,authorRdd,clcRdd,types,hiveContext)
//          simplifiedJournalRdd = newSimplifiedJournalRdd
//          authorRdd = newAuthorRdd
//      logUtil("处理完成")
//    })
//    ssc.start()
//    logUtil("start!")
//    ssc.awaitTermination()
//  }
//
//}
