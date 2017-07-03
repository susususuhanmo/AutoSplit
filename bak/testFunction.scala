//package com.zstu.libdata.StreamSplit.bak
//
//import com.zstu.libdata.dataCleanTools.StreamCleanAndMatch.DataOpsFunction.CommonTools._
//import com.zstu.libdata.dataCleanTools.StreamCleanAndMatch.DataOpsFunction.ReadData.readDataV2
//import com.zstu.libdata.dataCleanTools.StreamCleanAndMatch.StreamSplit.getCLC.getCLCRdd
//import com.zstu.libdata.dataCleanTools.StreamCleanAndMatch.StreamSplit.splitAuthorFunction.splitData
//import org.apache.spark.rdd.RDD
///**
//  * Created by Administrator on 2017/5/23 0023.
//  * 用于测试splitAuthorFunction
//  */
//object testFunction {
//  def main(args: Array[String]): Unit = {
//    val hiveContext = initSpark("test")
//    //inputData自动化时为stream读取的数据
//    val inputData = readDataV2("version2_DistinctResource_test01",hiveContext)
//
//    //读取作者表，得到CLC对应Rdd
//    var authorData = readDataV2("version2_Author_withSubjectAndKeyword",hiveContext).cache()
//    val CLCRdd = getCLCRdd(hiveContext)
//    val authorRdd: RDD[((String, String), String)] = authorData.map(row =>
//      ((row.getString(row.fieldIndex("name"))
//        , row.getString(row.fieldIndex("partOrgan"))), row.getString(row.fieldIndex("id"))))
//
//    //对新数据进行拆分匹配，写入paperAuthor表，新作者写入author表。并返回新作者数据
//    val newAuthor = splitData(inputData,authorRdd,CLCRdd,hiveContext)
//
//    //用新作者数据更新内存里的authorData
////    authorData = authorData.unionAll(newAuthor).cache()
//
//
//  }
//
//}
