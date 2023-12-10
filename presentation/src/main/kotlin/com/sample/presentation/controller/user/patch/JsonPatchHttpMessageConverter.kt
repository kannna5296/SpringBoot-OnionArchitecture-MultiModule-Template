package com.sample.presentation.controller.user.patch

import org.springframework.http.HttpInputMessage
import org.springframework.http.HttpOutputMessage
import org.springframework.http.MediaType
import org.springframework.http.converter.AbstractHttpMessageConverter
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.http.converter.HttpMessageNotWritableException
import org.springframework.stereotype.Component
import javax.json.Json
import javax.json.JsonPatch

@Component
class JsonPatchHttpMessageConverter : AbstractHttpMessageConverter<JsonPatch>(MediaType.valueOf("application/json-patch+json")) {

    override fun readInternal(clazz: Class<out JsonPatch>, inputMessage: HttpInputMessage): JsonPatch {
        try {
            Json.createReader(inputMessage.body).use { reader -> return Json.createPatch(reader.readArray()) }
        } catch (e: Exception) {
            throw HttpMessageNotReadableException(e.message!!, inputMessage)
        }
    }

    override fun writeInternal(jsonPatch: JsonPatch, httpOutputMessage: HttpOutputMessage) {
        try {
            Json.createWriter(httpOutputMessage.body).use { writer -> writer.write(jsonPatch.toJsonArray()) }
        } catch (e: Exception) {
            throw HttpMessageNotWritableException(e.message!!, e)
        }
    }

    override fun supports(clazz: Class<*>): Boolean {
        return JsonPatch::class.java.isAssignableFrom(clazz)
    }
}