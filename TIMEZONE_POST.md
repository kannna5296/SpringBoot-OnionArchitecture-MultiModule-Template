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

```
{
    "zonedDateTime": "2024-05-18T06:30:00Z"
}
```
* 200OK
  * printlnすると→2024-05-18T06:30Z[UTC] 

