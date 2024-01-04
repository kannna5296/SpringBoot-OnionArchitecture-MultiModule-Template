

plugins {
    jacoco
}

dependencies {
    // domain層は何にも依存しない
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
