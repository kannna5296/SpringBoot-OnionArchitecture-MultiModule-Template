dependencies {
    implementation("com.h2database:h2:1.3.148")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    // infraはドメインに依存
    implementation(project(":domain"))
}
