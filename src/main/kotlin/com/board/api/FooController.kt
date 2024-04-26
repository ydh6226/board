package com.board.api

import com.board.api.common.ApiResponse
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class FooController {

    private val log = KotlinLogging.logger {}

    @GetMapping("/health")
    fun health(): ApiResponse<LocalDateTime> {
        log.info { "healthy" }
        return ApiResponse.success(LocalDateTime.now())
    }
}