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

クエリパラメータに記載されたタイムゾーンのままZonedDateTimeに保持する

* http://localhost:8080/test?zonedDateTime=2024-05-18T06:30:00Z 200OK
  * printlnすると→2024-05-18T06:30Z
* http://localhost:8080/test?zonedDateTime=2024-05-18T06:30:00%2B09:00 
  * printlnすると→2024-05-18T06:30+09:00

## spring.jackson.time-zone指定あり

クエリパラメータに記載されたタイムゾーンのままZonedDateTimeに保持する

️クエリパラメータの日付変換にはspring.jackson.time-zoneは効かない
-> リクエストボディの変換とは設定すべき値が別。時刻で範囲検索するGETリクエスト等設計する時は要注意

```application.yaml
spring:
  jackson:
    time-zone: Asia/Tokyo
```

* http://localhost:8080/test?zonedDateTime=2024-05-18T06:30:00Z 200OK
  * printlnすると→2024-05-18T06:30Z -> UTCのまま！！（上記jacksonの設定は効かない）
* http://localhost:8080/test?zonedDateTime=2024-05-18T06:30:00%2B09:00
  * printlnすると→2024-05-18T06:30+09:00

## WebDataBinderをカスタマイズした時

クエリパラメータに記載されたタイムゾーンによらず、常にJST時刻で保持される

```dtd
@ControllerAdvice
class WebDataBinderCustom {

    @InitBinder
    fun initBinder(binder: WebDataBinder) {
        binder.registerCustomEditor(
            ZonedDateTime::class.java,
            ZonedDateTimeJSTEditor()
        )
    }

    class ZonedDateTimeJSTEditor : PropertyEditorSupport() {

        override fun setAsText(text: String?) {
            if (!text.isNullOrEmpty()) {
                val zdt = ZonedDateTime.parse(text, DateTimeFormatter.ISO_DATE_TIME)
                val zonedId= ZoneId.of("Asia/Tokyo")
                val jstZdt = zdt.withZoneSameInstant(zonedId)
                value = jstZdt
            } else {
                value = null
            }
        }
    }
}
```

* http://localhost:8080/test?zonedDateTime=2024-05-18T06:30:00Z 200OK
  * printlnすると→2024-05-18T15:30+09:00[Asia/Tokyo] -> JSTに変換される！
* http://localhost:8080/test?zonedDateTime=2024-05-18T06:30:00%2B09:00 
  *  printlnすると→2024-05-18T15:30+09:00[Asia/Tokyo] -> JSTのままで保持！