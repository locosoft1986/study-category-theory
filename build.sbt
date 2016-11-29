name := "study-category-theory"

organization := "com.github.dnvriend"

version := "1.0.0"

scalaVersion := "2.11.8"

resolvers ++= Seq(
  "scalaz" at "http://dl.bintray.com/scalaz/releases",
  "Scalaz Bintray Repo" at "http://dl.bintray.com/stew/snapshots",
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

libraryDependencies ++= {
  val akkaVersion = "2.4.14"
  Seq(
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    "com.chuusai" %% "shapeless" % "2.3.2",
    "io.github.scala-hamsters" %% "hamsters" % "1.0.7",
    "org.scalaz" %% "scalaz-core" % "7.2.7",
    "org.typelevel" %% "scalaz-outlaws" % "0.3",
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,
    "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % Test,
    "org.typelevel" %% "scalaz-scalatest" % "1.1.1" % Test,
    "org.scalatestplus.play" %% "scalatestplus-play" % "2.0.0-M1" % Test
  )
}

scalacOptions ++= Seq("-feature", "-language:higherKinds", "-language:implicitConversions", "-deprecation", "-Ybackend:GenBCode", "-Ydelambdafy:method", "-target:jvm-1.8", "-Xexperimental")

fork in Test := true

parallelExecution := false

licenses +=("Apache-2.0", url("http://opensource.org/licenses/apache2.0.php"))

// enable scala code formatting //
import scalariform.formatter.preferences._
import com.typesafe.sbt.SbtScalariform

// Scalariform settings
SbtScalariform.autoImport.scalariformPreferences := SbtScalariform.autoImport.scalariformPreferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 100)
  .setPreference(DoubleIndentClassDeclaration, true)

// enable updating file headers //
import de.heikoseeberger.sbtheader.license.Apache2_0

headers := Map(
  "scala" -> Apache2_0("2016", "Dennis Vriend"),
  "conf" -> Apache2_0("2016", "Dennis Vriend", "#")
)

enablePlugins(AutomateHeaderPlugin, PlayScala)