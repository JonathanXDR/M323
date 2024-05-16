ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.4.2"

lazy val root = (project in file("."))
  .settings(
    name := "M323",
    idePackagePrefix := Some("com.jonathan-russ.m323")
  )
