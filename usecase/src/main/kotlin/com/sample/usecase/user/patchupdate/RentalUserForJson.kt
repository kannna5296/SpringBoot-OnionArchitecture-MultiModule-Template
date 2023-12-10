package com.sample.usecase.user.patchupdate

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import javax.json.JsonStructure
import javax.json.JsonValue

data class RentalUserForJson @JsonCreator constructor(
    @JsonProperty("id") var id: Int? = null,
    @JsonProperty("name") val name: String,
    @JsonProperty("phone") val phone: String?,
    @JsonProperty("mail") val mail: String,
): JsonStructure {
    override fun getValueType(): JsonValue.ValueType {
        return JsonValue.ValueType.OBJECT
    }
}
