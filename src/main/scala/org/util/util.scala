package org.util

import org.apache.spark.sql.SparkSession

object util {

  implicit val ss = SparkSession
    .builder()
//    .master("local[*]")
    .appName("count")
    .getOrCreate()
      .sparkContext

}
