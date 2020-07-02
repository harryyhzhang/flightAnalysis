name := "flightAnalysis"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.4"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.4"

libraryDependencies += "org.apache.spark" %% "spark-hive" % "2.4.4"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"
libraryDependencies += "org.apache.spark" % "spark-mllib_2.11" % "1.3.0"
