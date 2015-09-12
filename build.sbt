name := "gymix"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws,
  "com.google.zxing"   %  "core"                 % "3.2.1",
  "org.webjars" 	   %  "bootstrap" 			 % "3.3.5",
    "javax.inject" % "javax.inject" % "1"
)

includeFilter in (Assets, LessKeys.less) := "*.less"
