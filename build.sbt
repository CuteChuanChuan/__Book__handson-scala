ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.4.0"

lazy val root = (project in file("."))
  .settings(
    name := "Hands-On-Scala"
  )

libraryDependencies += "com.lihaoyi" %% "pprint" % "0.8.1"
