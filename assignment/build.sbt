name := "assignment"

version := "0.1"

scalaVersion := "2.12.8"

trapExit := false

libraryDependencies ++= Seq (
  "io.cucumber" % "cucumber-core" % "4.2.0" % " test " ,
  "io.cucumber" % "cucumber-jvm" % "4.2.0" % " test " ,
  "io.cucumber" % "cucumber-junit" % "4.2.0" % " test " ,
  "io.cucumber" % "cucumber-java" % "4.2.0",
  "org.xerial" % "sqlite-jdbc" % "3.25.2",
  "com.novocode" % "junit-interface" % "0.11" % "test"
)
