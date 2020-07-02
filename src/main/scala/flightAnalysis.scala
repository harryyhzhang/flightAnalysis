import org.apache.spark.sql.SparkSession

object flightAnalysis extends App{
  val sc = SparkSession
    .builder()
          .master("local[*]")
    .appName("Spark SQL basic example")
    .getOrCreate()
  sc.sparkContext.setLogLevel("ERROR")


  private val dataPath = "./data"
  val flightrdd=sc.read.option("header","true").csv(dataPath+"/airlines.csv")
  flightrdd.toDF().write.option("header","true").mode("overwrite").csv(dataPath + "/result")

  sc.close()
}
