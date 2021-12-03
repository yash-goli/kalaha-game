package com.game.bol.kalaha.exceptions

import org.slf4j.LoggerFactory
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
class KalahaGameExceptionHandler {
    companion object {
        private val logger = LoggerFactory.getLogger(ResponseEntityExceptionHandler::class.java)
    }

    @ExceptionHandler(value = [Exception::class, KalahaApiException::class])
    fun handleExceptionGeneric(e: Exception): ResponseEntity<*> {
        logger.error(e.message)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(KalahaGameExceptionResponseModel(Date().toString(), e::class.simpleName.toString(), e.message ?: ""))
    }
}