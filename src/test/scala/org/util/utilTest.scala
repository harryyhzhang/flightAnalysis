package org.util

import org.apache.spark.sql.SparkSession

object utilTest {

  implicit val testsc = SparkSession
    .builder()
    .master("local[*]")
    .appName("count")
    .getOrCreate()
      .sparkContext

}
