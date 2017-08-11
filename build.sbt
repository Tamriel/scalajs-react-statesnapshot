import sbt.Keys.libraryDependencies

enablePlugins(ScalaJSPlugin)

name := "Scala.js React boilerplate"

scalaVersion := "2.12.2"

scalaJSUseMainModuleInitializer := true

resolvers += Resolver.mavenLocal

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.2",
  "com.github.japgolly.scalajs-react" %%% "core" % "1.1.0",
  "com.github.japgolly.scalacss" %%% "core" % "0.5.3",
  "com.github.japgolly.scalacss" %%% "ext-react" % "0.5.3",
  "com.github.japgolly.scalajs-react" %%% "ext-monocle" % "1.1.0",
  "com.github.julien-truffaut" %%% "monocle-core" % "1.4.0",
  "com.github.julien-truffaut" %%% "monocle-macro" % "1.4.0"
)

// for monocle
addCompilerPlugin(
  "org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

jsDependencies ++= Seq(
  "org.webjars.bower" % "react" % "15.5.4"
    / "react-with-addons.js"
    minified "react-with-addons.min.js"
    commonJSName "React",
  "org.webjars.bower" % "react" % "15.5.4"
    / "react-dom.js"
    minified "react-dom.min.js"
    dependsOn "react-with-addons.js"
    commonJSName "ReactDOM",
  "org.webjars.bower" % "react" % "15.5.4"
    / "react-dom-server.js"
    minified "react-dom-server.min.js"
    dependsOn "react-dom.js"
    commonJSName "ReactDOMServer"
)
