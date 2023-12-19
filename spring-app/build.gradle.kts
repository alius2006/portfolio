plugins {
    id("java")
}

group = "org.alius2006"
version = "1.0-SNAPSHOT"



repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework:spring-context:6.1.2")

    testImplementation("io.cucumber:cucumber-java:7.15.0")
    testImplementation("io.cucumber:cucumber-junit:7.15.0")
    testImplementation("io.cucumber:cucumber-spring:7.15.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.0")
}