import play.Project._

name := "test-play"

version := "1.0"

libraryDependencies ++= Seq(jdbc, anorm, "mysql" % "mysql-connector-java" % "5.1.27")

playScalaSettings