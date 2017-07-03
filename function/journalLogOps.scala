package com.zstu.libdata.StreamSplit.function

import org.apache.spark.rdd.RDD

/**
  * Created by Administrator on 2017/6/22 0022.
  */
object journalLogOps {





  def writeJournalLog(value :
                      RDD[(String, String, String, String, String, String
                        , String, String, String, String, String, String, String
                        , String, Int, Int, String, String, String, String, String
                        , Option[(String, String)])]) ={


    //    ,operater,operateTime,source


    //  (id,title,titleAlt,creator,creatorAlt,creatorAll,keyword
    //    ,keywordAlt,institute,instituteAll,year,journal,issue
    //    ,url,isCore,isCheck,otherId
    //    ,volume,page,classifications,abstract,abstractAlt,candidateResources
    //  ,subject)



  }

}
