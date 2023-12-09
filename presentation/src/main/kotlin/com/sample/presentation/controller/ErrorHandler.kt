package com.sample.presentation.controller

import org.springframework.context.MessageSource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.Locale

@RestControllerAdvice
class ErrorHandler(
    private val messageSource: MessageSource,
) {

    @ExceptionHandler
    fun handleException(exception: IllegalArgumentException): ResponseEntity<ErrorResponse> {
        exception.printStackTrace()
        val code = exception.message!!
        val message = messageSource.getMessage(code,null, Locale.getDefault())
        val errorResponse = ErrorResponse(code, message)
        return ResponseEntity.badRequest().body(errorResponse)
    }

    @ExceptionHandler
    fun handleException(exception: Exception): ResponseEntity<ErrorResponse> {
        exception.printStackTrace()
        val errorResponse = ErrorResponse("XXX", "想定外のエラー")
        return ResponseEntity.internalServerError().body(errorResponse)
    }
}