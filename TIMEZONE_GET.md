```
@RestController
@RequestMapping("/")
@Tag(name = "Book", description = "書籍情報")
class TestController {

    @GetMapping("/test")
    fun hoge(@ModelAttribute form: TestForm) : ResponseEntity<Void> {
        println(form.zonedDateTime)
        return ResponseEntity.ok().build()
    }
}

data class TestForm(

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    val zonedDateTime: ZonedDateTime
)
```

## spring.jackson.time-zone指定なし

* http://localhost:8080/test?zonedDateTime=2024-05-18T06:30:00Z 200OK
  * printlnすると→2024-05-18T06:30Z
* http://localhost:8080/test?zonedDateTime=2024-05-18T06:30:00 500OK
* http://localhost:8080/test?zonedDateTime=2024-05-18T06:30:00+09:00 500NG

## spring.jackson.time-zone指定あり

️クエリパラメータの日付変換にはspring.jackson.time-zoneは効かない
-> 時刻で検索かける時は要注意

```application.yaml
spring:
  jackson:
    time-zone: Asia/Tokyo
```

* http://localhost:8080/test?zonedDateTime=2024-05-18T06:30:00Z 200OK
  * printlnすると→2024-05-18T06:30Z -> UTCのまま！！（上記jacksonの設定は効かない）
* http://localhost:8080/test?zonedDateTime=2024-05-18T06:30:00 500OK
* http://localhost:8080/test?zonedDateTime=2024-05-18T06:30:00+09:00 500NG
