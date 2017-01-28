name := "nestedjson"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= {
  Seq(
    "org.json4s" %% "json4s-ext" % "3.5.0",
    "org.json4s" %% "json4s-native" % "3.5.0",
    "org.scalatest" %% "scalatest" % "2.2.6" % Test
  )
}
