name := "conway"

version := "1.0"

scalaVersion := "2.10.2"

ideaExcludeFolders += ".idea"

ideaExcludeFolders += ".idea_modules"

// Test dependencies
libraryDependencies ++= Seq(
    "junit" % "junit" % "4.11" % "test",
    "org.scalatest" % "scalatest_2.10" % "2.0" % "test",
    "org.scala-tools.testing" % "specs_2.10" % "1.6.9" % "test"
)
