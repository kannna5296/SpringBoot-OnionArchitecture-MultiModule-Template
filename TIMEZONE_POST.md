```
@RestController
@RequestMapping("/")
@Tag(name = "Book", description = "書籍情報")
class TestController {

    @PostMapping("/test")
    fun post(@RequestBody req: TestRequest) : ResponseEntity<Void> {
        println(req.zonedDateTime)
        return ResponseEntity.ok().build()
    }
}

data class TestRequest(
    val zonedDateTime: ZonedDateTime
)
```

## spring.jackson.time-zone指定なし

リクエストボディに記載されたタイムゾーンによらず、UTCで保持する
※タイムゾーン指定しても強制的にUTCになる

```
{
    "zonedDateTime": "2024-05-18T06:30:00Z"
}
```
* 200OK
  * printlnすると→2024-05-18T06:30Z[UTC] 

```
{
    "zonedDateTime": "2024-05-18T06:30:00+09:00"
}
```
* 200OK
  * printlnすると→2024-05-18T06:30Z[UTC]

## spring.jackson.time-zone指定あり

リクエストボディに記載されたタイムゾーンによらず、JSTで保持する

```applicatio.yml
spring:
  jackson:
    time-zone: Asia/Tokyo
```

```
{
    "zonedDateTime": "2024-05-18T06:30:00Z"
}
```

* 200OK
  * printlnすると→2024-05-18T15:30+09:00[Asia/Tokyo]

```
{
    "zonedDateTime": "2024-05-18T15:30:00+09:00"
}
```

* 200OK
  * printlnすると→2024-05-18T15:30+09:00[Asia/Tokyo]

