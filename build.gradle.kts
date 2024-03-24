import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.3.0-SNAPSHOT"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.23"
	kotlin("plugin.spring") version "1.9.23"
}

group = "com.ericsson"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-neo4j")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	implementation ("org.projectlombok:lombok:1.18.22")
	annotationProcessor ("org.projectlombok:lombok:1.18.22")
	testAnnotationProcessor ("org.projectlombok:lombok:1.18.22")


	implementation ("org.springframework:spring-context:5.3.16")


	// Spring Annotation Support
	implementation ("org.springframework:spring-beans:5.3.16")

	// Spring Context Support
	implementation ("org.springframework:spring-context-support:5.3.16")



	testImplementation("junit:junit:4.13.1")
	testImplementation("io.kotest:kotest-runner-junit5-jvm:5.7.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnit()
}
