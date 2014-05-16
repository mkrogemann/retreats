name := "gol-scala"

version := "1.0"

scalaVersion := "2.10.2"

ideaExcludeFolders += ".idea"

ideaExcludeFolders += ".idea_modules"

// Test dependencies
libraryDependencies ++= Seq(
    "junit" % "junit" % "4.11" % "test",
    "org.scalatest" % "scalatest_2.10" % "2.0" % "test"
)
