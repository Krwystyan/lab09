plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.75.0"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.mvc.SimpleGUI")
}

tasks.javadoc {
    isFailOnError = false
}

dependencies {
    compileOnly("com.github.spotbugs:spotbugs-annotations:4.7.3") // Use the latest version
}
