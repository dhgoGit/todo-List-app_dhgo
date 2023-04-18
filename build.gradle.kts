import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.10"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
	kotlin("plugin.jpa") version "1.6.10"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_15

configurations {
	all{
		exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
	}
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("mysql:mysql-connector-java:8.0.32")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	compileOnly("org.projectlombok:lombok")
	runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")

	testImplementation("io.kotest:kotest-runner-junit5:4.6.1")
	testImplementation("io.kotest:kotest-assertions-core-jvm:4.6.1")
	testImplementation("io.kotest:kotest-property-jvm:4.6.1")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.1")



	implementation("org.springframework.boot:spring-boot-starter-log4j2")
	implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml")


}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		jvmTarget = "15"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
