package com.sample

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

// :presentation:bootRun用のメインクラス
@SpringBootApplication
@OpenAPIDefinition(info = Info(title = "書籍管理システム API仕様", description = "書籍管理システムのAPI仕様書です。", version = "v0.1"))
class Application
fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
