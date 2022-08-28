dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin") // Form用のデシリアライズに用いる
    // usecaseに依存
    implementation(project(":usecase"))
    implementation(project(":domain"))
    // DI対象(domain層のRepositoryインターフェース)指定のためruntimeで入れる
    // 参考 > https://blog.takehata-engineer.com/entry/realizing-an-onion-architecture-in-kotlin-and-spring-boot-with-gradle-multi-project
    runtimeOnly(project(":infra"))

}
