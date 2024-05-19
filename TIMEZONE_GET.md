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

* http://localhost:8080/test?zonedDateTime=2024-05-18T06:30:00Z 200OK
  * printlnすると→2024-05-18T06:30Z
* http://localhost:8080/test?zonedDateTime=2024-05-18T06:30:00 500OK
* http://localhost:8080/test?zonedDateTime=2024-05-18T06:30:00+09:00 500NG

