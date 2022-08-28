package com.sample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

// :presentation:bootRun用のメインクラス
@SpringBootApplication
class Application
fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
