package com.board.api.common

import com.board.core.common.exception.BadRequestException
import com.fasterxml.jackson.databind.node.ObjectNode
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    private val log = KotlinLogging.logger {}

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(e: BadRequestException): ApiResponse<ObjectNode> {
        log.info(e) { "Bad Request" }
        return ApiResponse.fail(e.message)
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException(e: RuntimeException): ApiResponse<ObjectNode> {
        log.error(e) { "Internal Server Error" }
        return ApiResponse.fail(e.message ?: "Internal Server Error")
    }
}