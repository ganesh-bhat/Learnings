name := "shoppingcart2"

version := "1.0"

lazy val `shoppingcart2` = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.10.3"

libraryDependencies ++= Seq( javaJdbc , javaEbean , cache , javaWs )

libraryDependencies ++= "com.h2database" % "h2" % "1.4.192"

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  