//package com.zstu.libdata.StreamSplit.bak
//
//import com.zstu.libdata.dataCleanTools.StreamCleanAndMatch.AuthorFunction.Filter
//import com.zstu.libdata.dataCleanTools.StreamCleanAndMatch.AuthorFunction.getFirstLevelOrgan.getFirstLevelOrgan
//import com.zstu.libdata.dataCleanTools.StreamCleanAndMatch.AuthorFunction.printLog._
//import com.zstu.libdata.dataCleanTools.StreamCleanAndMatch.DataOpsFunction.CommonTools._
//import com.zstu.libdata.dataCleanTools.StreamCleanAndMatch.DataOpsFunction.WriteData.writeDataStream
//import com.zstu.libdata.dataCleanTools.StreamCleanAndMatch.StreamSplit.getCLC.addCLCName
//import com.zstu.libdata.StreamSplit.function.fn_GetPinyin.fn_GetPinyin
//import org.apache.spark.rdd.RDD
//import org.apache.spark.sql.hive.HiveContext
//
//import scala.collection.immutable.IndexedSeq
//
///**
//  * Created by Administrator on 2017/5/5 0005
//  *
//  */
//
//object splitAuthorFunctionBak {
//
//
//  case class expert(operater: String,id: String,name: String,pinyin: String
//                    ,subject: String,updateSubject: String,keyword: String,keywordAlt: String,
//updateKeyword: String,updateKeywordAlt: String,organization: String)
//  case class testAuthor(author: String, orgin: String, firstLevelOrgan: String,
//                        isFirstuthor: String, authorId: String, isNew: String, partOrgan: String
//                       ,keywords: String,keywordAlt: String,classifications:String)
//
//  case class splitedData(name: String, organ: String, firstLevelOrgan: String
//                         , partOrgan: String,isFirst:Boolean,id:String,journal:String)
//  def distinctAndCatStr(str1: String, str2: String) = {
//    if(str1 == null) str2
//    else if(str2 == null) str1
//    else str1.split(";")
//      .union(str2.split(";"))
//      .distinct
//      .reduce(_ + ";" + _)
//  }
//
//  def getAny5(any: Any):(String,String,String,String,String) = {
//    def myToString(a:Any):String ={
//      if (a == null)  null
//      else a.toString
//    }
//    any match {
//      case (a, b, c,d,e) => (myToString(a), myToString(b), myToString(c),myToString(d),myToString(e))
//      case _ => (null,null,null,null,null)
//    }
//  }
//  def getAny4(any: Any):(String,String,String,String) = {
//    def myToString(a:Any):String ={
//      if (a == null)  null
//      else a.toString
//    }
//    any match {
//      case (a, b, c,d) => (myToString(a), myToString(b), myToString(c),myToString(d))
//      case _ => (null,null,null,null)
//    }
//  }
//
//  /** 拆分单条数据
//    *
//    * @param value 待拆分数据((allAuthors, allOrgins), otherValue)
//    * @return 拆分作者机构后的多条数据IndexedSeq[(author, orgin, firstLevelOrgan, isFirst(i), otherValue，type)]
//    *         type：1、值为-1的为一对一匹配
//    *         2、值不为-1的为机构序号，0即为第一机构。
//    **/
//  def splitAutorAndOrgan(value: ((String, String), Any)):
//  IndexedSeq[(String, String, String, String, Any, Int)] = {
//
//    val ((allAuthors, allOrgins), otherValue) = value
//    //    logUtil("part1开始" + allAuthors)
//    //    logUtil(allOrgins)
//    if (isMeaningless(allAuthors) || allOrgins == null) {
//      null
//    } else {
//      //将作者和机构拆分成两个数组
//      val authors = splitStr(allAuthors, mode = "clean")
//      val organs = splitStr(allOrgins, mode = "clean")
//
//      def isFirst(i: Int): String = {
//        if (i == 0) "1" else "0"
//      }
//      if (authors == null || organs == null || authors.isEmpty || organs.isEmpty) {
//        null
//      }
//      else if (authors.length == organs.length) {
//        for (i <- authors.indices)
//          yield (authors(i), organs(i), getFirstLevelOrgan(organs(i)), isFirst(i), otherValue, -1)
//      }
//      else if (authors.nonEmpty && organs.length == 1) {
//        for (i <- authors.indices)
//          yield (authors(i), organs(0), getFirstLevelOrgan(organs(0)), isFirst(i), otherValue, -1)
//      }
//      else {
//        for (i <- authors.indices; j <- organs.indices)
//          yield (authors(i), organs(j), getFirstLevelOrgan(organs(j)), isFirst(i), otherValue, j)
//      }
//    }
//  }
//
//
//
//  /**
//    *
//    * @param value1 value1
//    * @param value2 value2
//    * @return
//    */
//  def reduceAuthorNew(value1: ((String, String, String, String, Any, Int, Any), Double)
//                   , value2: ((String, String, String, String, Any, Int, Any), Double)): ((String, String, String, String, Any, Int, Any), Double) = {
////    val (author1, orgin1, firstLevelOrgan1, isFirstuthor1, otherValue1, organNum1, authorId1) = value1._1
////    val (author2, orgin2, firstLevelOrgan2, isFirstuthor2, otherValue2, organNum2, authorId2) = value1._1
//
//    if (value1._2 > value2._2) value1 else value2
//
//  }
//  def reduceAuthor(value1: ((String, String, String, String, Any, Int, String), Double)
//                   , value2: ((String, String, String, String, Any, Int, String), Double)): ((String, String, String, String, Any, Int, String), Double) = {
//    //    val (author1, orgin1, firstLevelOrgan1, isFirstuthor1, otherValue1, organNum1, authorId1) = value1._1
//    //    val (author2, orgin2, firstLevelOrgan2, isFirstuthor2, otherValue2, organNum2, authorId2) = value1._1
//
//    if (value1._2 > value2._2) value1 else value2
//
//  }
//
//  /**
//    * 得到优先级
//    *
//    * @param value ： ((author, orgin, firstLevelOrgan, isFirstuthor, otherValue,organNum),authorId)
//    * @return
//    */
//  def getLevel(value: ((String, String), ((String, String, String, String, Any, Int), Option[Any])))
//  : Double = {
//    val ((author, orgin, firstLevelOrgan, isFirstuthor, otherValue, organNum), authorId) = value._2
//    var level = 0
//    if (authorId.orNull != null) level += 8
//    if (organNum == -1) level += 4
//    if (isFirstuthor == "1" && organNum == 0) level += 2
//    if (isFirstuthor != "1" && organNum == 0) level += 1
//    val length = getLength(orgin)
//    val lengthLevel = 1 - (if (length != 0) length / 100 else 1)
//    level + lengthLevel
//  }
//
//
//
//
//
//  def splitRdd(inputRdd: RDD[((String, String), Any)], authorRdd:  RDD[((String, String), String)], CLCRdd: (RDD[(String, (String, String))]), hiveContext: HiveContext)
//  : RDD[((String, String), String)] = {
//    logUtil("进入拆分数量" + inputRdd.count())
//    val cleanedInputRdd = inputRdd.filter(value => !isMeaningless(value._1._1) && !isMeaningless(value._1._2))
//     logUtil("清洗完成" + cleanedInputRdd.count)
//    val splitedRdd = cleanedInputRdd.flatMap(splitAutorAndOrgan)
//      .filter(f => f != null)
//      .filter(value => Filter.authorFilter(value._1))
//      .map(value => (value._1, value._2, value._3, value._4, value._5, value._6))
//      .filter(value => value._1.length > 1 && value._2.length > 1 && !Filter.isOverlongName(value._1) && Filter.organFilter(value._2))
//
//
//    //    logUtil("拆分完成" + splitedRdd.count)
//    //(author, orgin, firstLevelOrgan, isFirstuthor, otherValue，organNum)
//    val (oneToOneRdd, notOneToOneRdd) = (splitedRdd.filter(_._6 == -1).map(value => ((value._1, cutStr(value._3, 4)), value)), splitedRdd.filter(_._6 != -1))
//
//    //    logUtil("过滤一对一 非一对一完成 " + oneToOneRdd.count + "    " + notOneToOneRdd.count)
//    // 一、取非一对一可能为新的数据:第一作者第一机构
//    val (firstAuthorMatched, otherAuthor)
//    = (notOneToOneRdd.filter(value => value._6 == 0 && value._4 == "1").map(value => ((value._1, cutStr(value._3, 4)), value))
//      , notOneToOneRdd.filter(value => value._4 != "1").map(value => ((value._1, cutStr(value._3, 4)), value)))
//
//    //  剔除掉第一作者的其他机构，和作者表进行匹配。
//    //    otherAuthor: ((author,partorgan),value)
//
//    //    logUtil("过滤第一作者完成")
//    //(author,partOrgan),(author, orgin, firstLevelOrgan, isFirstuthor, otherValue，organNum,authorId)
//    val joinedRdd: RDD[((String, String), ((String, String, String, String, Any, Int, String), Double))]
//    = otherAuthor.union(firstAuthorMatched).union(oneToOneRdd)
//      .leftOuterJoin(authorRdd)
//      .map(value =>
//        (value._1, ((value._2._1._1, value._2._1._2, value._2._1._3, value._2._1._4, value._2._1._5, value._2._1._6, value._2._2.orNull), getLevel(value))))
//      .filter(value => value._2._2 >= 1)
//
//    //    logUtil("匹配完成" + joinedRdd.count)
//    // 找到新数据和旧数据
//    //    (author, orgin, firstLevelOrgan, isFirstuthor, otherValue，organNum,authorId)
//    val exactAuthor: RDD[(String, String, String, String, Any, Int, String)]
//    = joinedRdd.reduceByKey(reduceAuthor).map(value => value._2._1)
//    //    logUtil("reduce完成" + exactAuthor.count)
//    val (oldAuthor, newAuthorWithoutId) = (exactAuthor.filter(value => value._7 != null), exactAuthor.filter(value => value._7 == null))
//
//    val newAuthor: RDD[(String, String, String, String, Any, Int, String)] =
//      newAuthorWithoutId.map(value => (value._1, value._2, value._3, value._4, value._5, value._6, newGuid())).cache()
//    //    logUtil("作者数据生成完成" + newAuthor.count + "+++" + oldAuthor.count)
//
//
//
//
//
//
//    //todo 旧作者通过authorData进行补充
//    val oldData = hiveContext.createDataFrame(oldAuthor.map(value =>
//      testAuthor(value._1, value._2, value._3, value._4, value._7, "old", cutStr(value._2, 4)
//        ,getAny4(value._5)._1,getAny4(value._5)._2,getAny4(value._5)._3)))
//
//
//    val newData = hiveContext.createDataFrame(newAuthor.map(value =>
//      testAuthor(value._1, value._2, value._3, value._4, value._7, "new", cutStr(value._2, 4)
//        ,getAny4(value._5)._1,getAny4(value._5)._2,getAny4(value._5)._3)))
//
//    val newDataWithSubjects = addCLCName(newData,CLCRdd,hiveContext)
//newDataWithSubjects.count()
//    //    writeDataV2("version2_testAuthor", oldData, hiveContext)
//    // TODO: 写入数据 需放开
////    writeDataStream("version2_testAuthor", newDataWithSubjects, hiveContext)
//
//
//
//
//
//
//
//    val authorIdData = oldData.unionAll(newData).select("author", "partOrgan", "authorId")
//      .withColumnRenamed("author", "midauthor")
//      .withColumnRenamed("partOrgan", "midpartOrgan")
//
//
//    //    case class splitedData(author: String, organ: String, firstLevelOrgan: String
//    //                           , partOrgan: String,authorId)
//    //    (author, orgin, firstLevelOrgan, isFirst(i), otherValue,type)
//    val paperAuthorWithoutId = hiveContext
//      .createDataFrame(splitedRdd
//        .map(value => splitedData(value._1, value._2, value._3, cutStr(value._2, 4),
//          if (value._4 == "0") false else true,getAny5(value._5)._4,getAny5(value._5)._5)))
//    val paperAuthorData = paperAuthorWithoutId.join(authorIdData,
//      paperAuthorWithoutId("name") === authorIdData("midauthor")
//        and paperAuthorWithoutId("partOrgan") === authorIdData("midpartOrgan")
//      , "left").drop("midauthor").drop("midpartOrgan")
//
////    writeDataV2("version2_testPaperAuthor",paperAuthorData,hiveContext)
//
//    //    logUtil("写入成功")
//    val newRdd = newData.map(row =>
//      ((row.getString(row.fieldIndex("author"))
//        , row.getString(row.fieldIndex("partOrgan"))), row.getString(row.fieldIndex("authorId"))))
//    authorRdd.union(newRdd)
//
//  }
//
//
//
//
//
//  def toOldData(value : (String, String, String, String, Any, Int, Any)) ={
//    val (author, orgin, firstLevelOrgan, isFirstuthor, otherValue,organNum,joinValue) = value
////    case class expert(operater: String,id: String,name: String,pinyin: String
////                      ,subject: String,updateSubject: String,keyword: String,keywordAlt: String,
////                      updateKeyword: String,updateKeywordAlt: String,organization: String)
//    val (id,subject,keyword,keywordAlt) =getAny4(joinValue)
//    val (keywordNew,keywordAltNew,subjectNew,paperId,journal)= getAny5(otherValue)
////    (jsonMap("keyword"), null, jsonMap("subject"), jsonMap("id"), jsonMap("journal"))
//   val  updateSubject = distinctAndCatStr(subject,subjectNew)
//    val  updateKeyword = distinctAndCatStr(keyword,keywordNew)
//   val  updateKeywordAlt = distinctAndCatStr(keywordAlt,keywordAltNew)
//    expert("2",id: String,author: String,fn_GetPinyin(author): String
//      ,subject: String,updateSubject: String,keyword: String,keywordAlt: String,
//      updateKeyword: String,updateKeywordAlt: String,firstLevelOrgan: String)
//  }
//
//
//  /**
//    *
//    * @param inputRdd
//    * @param authorRdd (name partOrgan) Any： (id,subject,keyword,keywordAlt)
//    * @param CLCRdd
//    * @param hiveContext
//    * @return
//    */
//  def splitRddNew(inputRdd: RDD[((String, String), Any)], authorRdd:  RDD[((String, String), Any)], CLCRdd: (RDD[(String, (String, String))]), hiveContext: HiveContext)
//  : RDD[((String, String), Any)] = {
//
//
//    logUtil("进入拆分数量" + inputRdd.count())
//    val cleanedInputRdd = inputRdd.filter(value => !isMeaningless(value._1._1) && !isMeaningless(value._1._2))
//    logUtil("清洗完成" + cleanedInputRdd.count)
//    val splitedRdd = cleanedInputRdd.flatMap(splitAutorAndOrgan)
//      .filter(f => f != null)
//      .filter(value => Filter.authorFilter(value._1))
//      .map(value => (value._1, value._2, value._3, value._4, value._5, value._6))
//      .filter(value => value._1.length > 1 && value._2.length > 1 && !Filter.isOverlongName(value._1) && Filter.organFilter(value._2))
//
//
//    //    logUtil("拆分完成" + splitedRdd.count)
//    //(author, orgin, firstLevelOrgan, isFirstuthor, otherValue，organNum)
//    val (oneToOneRdd, notOneToOneRdd) = (splitedRdd.filter(_._6 == -1).map(value => ((value._1, cutStr(value._3, 4)), value)), splitedRdd.filter(_._6 != -1))
//
//    //    logUtil("过滤一对一 非一对一完成 " + oneToOneRdd.count + "    " + notOneToOneRdd.count)
//    // 一、取非一对一可能为新的数据:第一作者第一机构
//    val (firstAuthorMatched, otherAuthor)
//    = (notOneToOneRdd.filter(value => value._6 == 0 && value._4 == "1").map(value => ((value._1, cutStr(value._3, 4)), value))
//      , notOneToOneRdd.filter(value => value._4 != "1").map(value => ((value._1, cutStr(value._3, 4)), value)))
//
//    //  剔除掉第一作者的其他机构，和作者表进行匹配。
//    //    otherAuthor: ((author,partorgan),value)
//
//    //    logUtil("过滤第一作者完成")
//    //(author,partOrgan),(author, orgin, firstLevelOrgan, isFirstuthor, otherValue，organNum,(id,subject,keyword,keywordAlt))
//    val joinedRdd: RDD[((String, String), ((String, String, String, String, Any, Int, Any), Double))]
//    = otherAuthor.union(firstAuthorMatched).union(oneToOneRdd)
//      .leftOuterJoin(authorRdd)
//      .map(value =>
//        (value._1, ((value._2._1._1, value._2._1._2, value._2._1._3, value._2._1._4, value._2._1._5, value._2._1._6, value._2._2.orNull), getLevel(value))))
//      .filter(value => value._2._2 >= 1)
//
//    //    logUtil("匹配完成" + joinedRdd.count)
//    // 找到新数据和旧数据
//    //    (author, orgin, firstLevelOrgan, isFirstuthor, otherValue，organNum,(id,subject,keyword,keywordAlt))
//    val exactAuthor: RDD[(String, String, String, String, Any, Int, Any)]
//    = joinedRdd.reduceByKey(reduceAuthorNew).map(value => value._2._1)
//    //    logUtil("reduce完成" + exactAuthor.count)
//    val (oldAuthor, newAuthorWithoutId) = (exactAuthor.filter(value => value._7 != null), exactAuthor.filter(value => value._7 == null))
//
//    val newAuthor: RDD[(String, String, String, String, Any, Int, String)] =
//      newAuthorWithoutId.map(value => (value._1, value._2, value._3, value._4, value._5, value._6, newGuid())).cache()
//    //    logUtil("作者数据生成完成" + newAuthor.count + "+++" + oldAuthor.count)
//
//
//
//
//
//
//
//
////
////    case class expert(operater: String,id: String,name: String,pinyin: String
////                      ,subject: String,updateSubject: String,keyword: String,keywordAlt: String,
////                      updateKeyword: String,updateKeywordAlt: String,organization: String)
//
//
////    (author, orgin, firstLevelOrgan, isFirstuthor, otherValue，organNum,(id,subject,keyword,keywordAlt))
//
//    // TODO: oldData已做好一部分。下一步需join得到城市，英文机构等。即可写入调试
//    val oldData = hiveContext.createDataFrame(oldAuthor.map(toOldData))
//    writeDataStream("t_ExpertLog",oldData)
//
//
//    // TODO: 后续需放开开始
////    val newData = hiveContext.createDataFrame(newAuthor.map(value =>
//    //      testAuthor(value._1, value._2, value._3, value._4, value._7, "new", cutStr(value._2, 4)
//    //        ,getAny4(value._5)._1,getAny4(value._5)._2,getAny4(value._5)._3)))
//    //
//    //    val newDataWithSubjects = addCLCName(newData,CLCRdd,hiveContext)
//    //    newDataWithSubjects.count()
//    //    //    writeDataV2("version2_testAuthor", oldData, hiveContext)
//    //    // TODO: 写入数据 需放开
//    //    //    writeDataStream("version2_testAuthor", newDataWithSubjects, hiveContext)
//    //
//    //
//    //
//    //
//    //
//    //
//    //
//    //    val authorIdData = oldData.unionAll(newData).select("author", "partOrgan", "authorId")
//    //      .withColumnRenamed("author", "midauthor")
//    //      .withColumnRenamed("partOrgan", "midpartOrgan")
//    //
//    //
//    //    //    (author, orgin, firstLevelOrgan, isFirst(i), otherValue,type)
//    //
//    //    val paperAuthorWithoutId = hiveContext
//    //      .createDataFrame(splitedRdd
//    //        .map(value => splitedData(value._1, value._2, value._3, cutStr(value._2, 4),
//    //          if (value._4 == "0") false else true,getAny5(value._5)._4,getAny5(value._5)._5)))
//    //    val paperAuthorData = paperAuthorWithoutId.join(authorIdData,
//    //      paperAuthorWithoutId("name") === authorIdData("midauthor")
//    //        and paperAuthorWithoutId("partOrgan") === authorIdData("midpartOrgan")
//    //      , "left").drop("midauthor").drop("midpartOrgan")
//    //
//    //    //    writeDataV2("version2_testPaperAuthor",paperAuthorData,hiveContext)
//    //
//    //    //    logUtil("写入成功")
//    //    val newRdd = newData.map(row =>
//    //      ((row.getString(row.fieldIndex("author"))
//    //        , row.getString(row.fieldIndex("partOrgan"))), row.getString(row.fieldIndex("authorId"))))
//    ////    authorRdd.union(newRdd)
//    //    newRdd
//
//    // TODO: 后续需放开结束
//    authorRdd
//  }
//
//
//}
