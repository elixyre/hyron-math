name := "hyron-math"

version := "0.2"

organization := "fr.hyron"

scalaVersion := "2.11.12"

conflictWarning := ConflictWarning.disable

libraryDependencies ++= Seq(
  "org.scalanlp" %% "breeze" % "0.13.2",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)

resolvers ++= Seq(
  "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/",
  "Artima Maven Repository" at "http://repo.artima.com/releases"
)

publishMavenStyle := false
publishTo := {
  val prefix = if (isSnapshot.value) "snapshots" else "releases"
  Some(s3resolver.value(s"My ${prefix} S3 bucket", s3(s"${prefix}.mvn-repo.hyron.fr")) withIvyPatterns)
}
