name := "cloudemployee-play-api"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean, JavaAppPackaging, LauncherJarPlugin)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
	javaJpa,
	filters,
  	"org.hibernate" % "hibernate-entitymanager" % "4.3.7.Final",
  	"joda-time" % "joda-time" % "2.4",
  	"org.avaje" % "ebean" % "2.7.3",
	"com.fasterxml.jackson.datatype" % "jackson-datatype-joda" % "2.0.1"
)

// Eclipse settings

// Compile the project before generating Eclipse files,
// so that generated .scala or .class files for views and routes are present
EclipseKeys.preTasks := Seq(compile in Compile)

// Java project. Don't expect Scala IDE
EclipseKeys.projectFlavor := EclipseProjectFlavor.Java

// Use .class files instead of generated .scala files for views and routes
EclipseKeys.createSrc := EclipseCreateSrc.ValueSet(EclipseCreateSrc.ManagedClasses, EclipseCreateSrc.ManagedResources)

// End of eclipse settings

fork in run := true