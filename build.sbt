lazy val commonSettings = Seq(
  organization := "se.ramn",
  version := "0.1-SNAPSHOT",
  scalaVersion := "2.11.7",
  scalacOptions ++= Seq(
    "-feature",
    "-unchecked",
    "-deprecation",
    "-encoding", "utf8",
    // "-Xfatal-warnings",
    "-Xlint",
    "-Yno-adapted-args",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Ywarn-value-discard",
    "-Xfuture",
    "-Ywarn-unused-import"
  ),
  testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-oD"),
  javacOptions ++= Seq("-Xlint:unchecked"),
  resolvers ++= Seq(
    "Typesafe releases" at "http://repo.typesafe.com/typesafe/releases",
    "Sonatype OSS Releases" at "https://oss.sonatype.org/content/repositories/releases"
  ),
  libraryDependencies ++= Seq(
    "com.badlogicgames.gdx" % "gdx" % libGdxVer,
    "com.badlogicgames.gdx" % "gdx-backend-lwjgl" % libGdxVer,
    "com.badlogicgames.gdx" % "gdx-controllers-desktop" % libGdxVer,
    "com.badlogicgames.gdx" % "gdx-freetype" % libGdxVer,
    "com.badlogicgames.gdx" % "gdx-freetype-platform" % libGdxVer classifier "natives-desktop",
    "com.badlogicgames.gdx" % "gdx-platform" % libGdxVer classifier "natives-desktop",

    "org.scalatest" %% "scalatest" % "2.2.2" % "test",
    "org.scalamock" %% "scalamock-scalatest-support" % "3.2.1" % "test"
  )
)

lazy val libGdxVer = "1.6.4"

lazy val common = (project in file("common"))
  .settings(commonSettings: _*)

lazy val desktop = (project in file("desktop"))
  .settings(commonSettings: _*)
  .settings(
    name := "objects-in-space",
    fork in Compile := true,
    mainClass := Some("se.ramn.DesktopStarter")
  )
  .dependsOn(common)
