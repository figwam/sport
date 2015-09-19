name := "gymix"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala,JavaAppPackaging)

scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "com.google.zxing"   %  "core"                 % "3.2.1",
  "org.webjars" 	   %  "bootstrap" 			 % "3.3.5",
  "javax.inject" % "javax.inject" % "1",
  "com.typesafe.slick" %% "slick" % "3.0.3",
  "org.postgresql" % "postgresql" % "9.4-1202-jdbc42",
  "org.slf4j" % "slf4j-nop" % "1.7.12",
  "com.typesafe.play" 	%% "play-slick" 		% "1.0.1",
  "com.typesafe.play" %% "anorm" % "2.4.0",
  "com.mohiva" %% "play-silhouette" % "3.0.0",
  "com.kyleu" %% "jdub-async" % "1.0"
)

routesGenerator := InjectedRoutesGenerator

includeFilter in (Assets, LessKeys.less) := "*.less"

herokuAppName in Compile := "ancient-shore-6366"


