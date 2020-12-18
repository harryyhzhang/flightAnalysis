
name := "flightAnalysis"

version := "0.2"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.4.4",
 "org.apache.spark" %% "spark-sql" % "2.4.4", "org.apache.spark" %% "spark-hive" % "2.4.4",
 "org.apache.spark" % "spark-mllib_2.11" % "1.3.0",
  "org.scalatest" %% "scalatest" % "3.0.5" % Test)


ThisBuild / scalaVersion := "2.11.8"
ThisBuild / organization := "com.intellioptimal"
//
//val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
//val gigahorse = "com.eed3si9n" %% "gigahorse-okhttp" % "0.3.1"
//val playJson  = "com.typesafe.play" %% "play-json" % "2.6.9"
//
//
//
//lazy val hello = (project in file("."))
//  .aggregate(helloCore)
//  .dependsOn(helloCore)
//  .settings(
//    name := "Hello",
//    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test,
//  )
//
//lazy val helloCore = (project in file("core"))  // this is the subfolder name, design for submoduel
//  .settings(
//    name := "Hello Core",
//    libraryDependencies ++= Seq(gigahorse, playJson),
//    libraryDependencies += scalaTest % Test
//  )
//
