package com.sample.presentation.controller.user.patch

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component
import java.util.function.BiFunction
import javax.json.JsonPatch
import javax.json.JsonStructure
import javax.json.JsonValue

@Component
class JsonPatchMapper<T>(private val objectMapper: ObjectMapper) : BiFunction<T, JsonPatch, T> {
    override fun apply(targetBean: T, patch: JsonPatch): T {
        // Convert the Java bean to a JSON document
        val target = objectMapper.convertValue(targetBean, JsonStructure::class.java)

        // Apply the JSON Patch to the JSON document
        val patched: JsonValue = patch.apply(target)

        // Convert the JSON document to a Java bean and return it
        return objectMapper.convertValue(patched, targetBean as Class<T>?)
    }
}