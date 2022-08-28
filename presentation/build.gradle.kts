dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin") // Form用のデシリアライズに用いる
    implementation(project(":usecase"))
    implementation(project(":domain"))
    // preseintation->infraの依存は必要。これがないとpresentation->usecase->infraというDIの流れが実現できずbootRun失敗する
    // 一方で、presentation層にinfra層のクラスを直接importさせたくない。そのため[runtime]で入れる
    // 参考 > https://blog.takehata-engineer.com/entry/realizing-an-onion-architecture-in-kotlin-and-spring-boot-with-gradle-multi-project
    runtimeOnly(project(":infra"))

}
