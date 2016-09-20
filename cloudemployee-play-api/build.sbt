name := "cloudemployee-play-api"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean, JavaAppPackaging, LauncherJarPlugin)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
	javaJpa,
  	"org.hibernate" % "hibernate-entitymanager" % "4.3.7.Final",
  	"joda-time" % "joda-time" % "2.4",
  	"org.avaje" % "ebean" % "2.7.3",
	"com.fasterxml.jackson.datatype" % "jackson-datatype-joda" % "2.0.1"
)


fork in run := true