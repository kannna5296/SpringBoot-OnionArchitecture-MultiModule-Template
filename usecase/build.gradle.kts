plugins {
    jacoco
}

dependencies {
    // cleanアーキテクチャの考え方に基づき、、usecase層はdomain層にのみ依存する
    implementation(project(":domain"))
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

