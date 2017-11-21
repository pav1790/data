name := """data"""
organization := "com.pjlosco"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  javaJdbc,
  javaJpa,
  guice,
  "org.postgresql" % "postgresql" % "9.3-1102-jdbc41",
  "com.h2database" % "h2" % "1.4.194",
  "org.hibernate" % "hibernate-core" % "5.2.5.Final",
  javaWs % "test",
  "org.awaitility" % "awaitility" % "2.0.0" % "test",
  "org.assertj" % "assertj-core" % "3.6.2" % "test",
  "org.mockito" % "mockito-core" % "2.1.0" % "test"
)

testOptions in Test += Tests.Argument(TestFrameworks.JUnit, "-a", "-v")
