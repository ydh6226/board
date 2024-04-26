package com.board.core.common.exception

class BadRequestException(
    override val message: String,
    override val cause: Throwable? = null
): RuntimeException()