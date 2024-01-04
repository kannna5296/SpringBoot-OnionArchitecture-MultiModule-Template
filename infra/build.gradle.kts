plugins {
    kotlin("kapt") // kotlin用アノテーションプロセッサ(annotationからクラス自動生成したりする)
    // 入れてビルドするとbuild/generated/フォルダが映える
    // dependencies内でkaptするのに必須
    jacoco
}

apply(plugin = "kotlin-kapt") // QEntity生成に必須

dependencies {
    implementation("com.h2database:h2:1.3.148")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    kapt("com.querydsl:querydsl-apt:5.0.0:jpa") // ここがQEntity生成のため必須
    implementation("com.querydsl:querydsl-jpa:5.0.0") // com.querydsl.jpa.impl.JPAQueryFactory利用のため必須

    // infraはドメインに依存
    implementation(project(":domain"))
    implementation(project(":usecase"))
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}
tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests are required to run before generating the report
    reports {
        html.isEnabled = true
        xml.isEnabled = true
        csv.isEnabled = false
    }
}
