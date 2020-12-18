package org

import org.apache.spark.{SparkConf, SparkContext}

object flightAnalysis {

  def airportcount()( implicit sc:SparkContext) ={
    val dataPath = "./data"
    val flightrdd=sc.textFile(dataPath+"/airlines.csv")
    println(flightrdd.count())
    val totalrowcount=flightrdd.map((str: String) => 1).fold(0)((i: Int, i1: Int) => i+i1 )
    print(flightrdd.toDebugString)
    println(totalrowcount)
  }


  def flightsum()( implicit sc:SparkContext) ={
    val dataPath = "/data/flights"
    val flightrdd=sc.textFile(dataPath+"/*.csv")
    val rdd1=flightrdd.map((str: String) => str.split(",")(1))
    val rdd2=flightrdd.map((str: String) => str.split(",")(2))
    val result=rdd1 ++ rdd2  //1m35s
//    val result=rdd1.union(rdd2)  //1m38s

    result.map((str: String) => (str,1)).reduceByKey((i: Int, i1: Int) => i+i1).collect().foreach( println _)
    print(flightrdd.toDebugString)
  }

  def flightSecondOrder()(implicit sc:SparkContext)={ //3m 11s
    val dataPath = "./data/flights"
    val flightrdd=sc.textFile(dataPath+"/20*.csv")
    val result=flightrdd.map((str: String) => str.split(",")).mapPartitionsWithIndex {
      (idx, iter) =>  iter.drop(1)
    }
      .map(r=>((r(0),r(1)),1))
      .groupByKey()
//      .sortByKey(false)  // it required sortbykey, becuase groupbykey does not sort
      .map(p=>(p._1,p._2.size))
        .collect()

    result.foreach(println _)
  }

  def flightSecondOrderv2()(implicit sc:SparkContext)={ //3m 17s
    val dataPath = "./data/flights"
    val flightrdd=sc.textFile(dataPath+"/20*.csv").mapPartitionsWithIndex {
      (idx, iter) =>   iter.drop(1)
    }
    val result=flightrdd.map((str: String) => str.split(","))
      .map(r=>((r(0),r(1)),1))
      .reduceByKey((i: Int, i1: Int) => i+i1)
      .map((tuple: ((String, String), Int)) => ((tuple._1._1,-tuple._1._2.toInt),tuple._2))
      .count()
    println(result)
/*
1.reducebykey should be put first over sortbykey, otherwise it will take more time.
  */
  }


  def flight_sortbykey()(implicit sc:SparkContext)= {
    val dataPath = "./data/flights"
    val flightrdd = sc.textFile(dataPath + "/2008.csv").mapPartitionsWithIndex {
      (idx, iter) => iter.drop(1)
    }
    flightrdd.map((str: String) => str.split(","))
      .map(r=>((r(0),r(1)),1))
      .sortByKey()
      .collect()
      .take(50)
      .foreach(println _)
  }

  def flight_sortby()(implicit sc:SparkContext)= {
    /*
  soryby did no utilize mapreduce framework, it cause the two much shuffling,to slow
  * */
    val dataPath = "./data/flights"
    val flightrdd = sc.textFile(dataPath + "/2008.csv").mapPartitionsWithIndex {
      (idx, iter) => iter.drop(1)
    }
    flightrdd.map((str: String) => str.split(","))
      .sortBy((r: Array[String]) => (r(0),r(1)),false)
      .collect()
      .take(50)
      .foreach(println _)
  }

//  sc.sparkContext.parallelize(1 to 10).fold(1000){(acc,element) => Math.min(acc, element)}
//  val flightrdd=sc.read.option("header","true").csv(dataPath+"/airlines.csv")
//  flightrdd.show(100)
////  flightrdd.rdd.fold(0)((row: Row, row1: Row) => )
//  flightrdd.toDF().write.option("header","true").mode("overwrite").csv(dataPath + "/result")
}
