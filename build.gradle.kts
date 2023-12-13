import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.3"
    id("io.spring.dependency-management") version "1.0.13.RELEASE"
    id("org.jlleitschuh.gradle.ktlint") version "10.3.0"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
    id("org.flywaydb.flyway") version "7.5.2" // flyway導入
}

group = "com.sample"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

// 以下、モジュール分割用構成（allrprojects/subprojects)
allprojects {
    repositories {
        mavenCentral()
    }
    apply(plugin = "kotlin")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    dependencies {
        implementation("org.postgresql:postgresql:42.5.1")
    }
}

subprojects {
    dependencies {
        implementation("org.springframework.boot:spring-boot-starter")
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.data:spring-data-commons:2.7.0") // 3系だとaot.BeanRegistrationAotProcessorがBean登録できず起動できない
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        testImplementation("org.springframework.boot:spring-boot-starter-test")

        testImplementation(kotlin("test"))
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

// flyway接続情報
flyway {
    url = "jdbc:postgresql://localhost:5432/sampledb"
    user = "postgres"
    password = "Password123"
    locations = arrayOf("filesystem:${project.projectDir}/presentation/src/main/resources/db/migration")
}

// DB生成タスク
task<Exec>("createPostgresDb") {
    commandLine("docker", "exec", "-i", "postgresql", "/usr/bin/psql", "-U", "postgres", "-c", "CREATE DATABASE sampleDb;")
}
