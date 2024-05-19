package com.sample.presentation.controller

import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.InitBinder
import java.beans.PropertyEditorSupport
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


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