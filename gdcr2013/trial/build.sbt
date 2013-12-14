name := "conway"

version := "1.0"

scalaVersion := "2.10.2"

ideaExcludeFolders ++= Seq( ".idea", ".idea_modules" )

// Test dependencies
libraryDependencies ++= Seq(
    "junit" % "junit" % "4.11" % "test",
    "org.scalatest" % "scalatest_2.10" % "2.0" % "test"
)
