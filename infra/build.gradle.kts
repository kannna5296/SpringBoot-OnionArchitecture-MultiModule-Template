dependencies {
    implementation("com.h2database:h2:1.3.148")
    // infraはドメインに依存
    implementation(project(":domain"))
}
