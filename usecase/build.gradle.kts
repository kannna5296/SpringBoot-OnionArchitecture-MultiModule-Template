dependencies {
    // cleanアーキテクチャの考え方に基づき、、usecase層はdomain層にのみ依存する
    implementation(project(":domain"))
}