package com.board.api.common

import com.fasterxml.jackson.databind.node.JsonNodeFactory
import com.fasterxml.jackson.databind.node.ObjectNode


class ApiResponse<T>(
    val success: Boolean,
    val data: T,
) {
    companion object {
        fun <T> success(data: T): ApiResponse<T> {
            return ApiResponse(true, data)
        }

        fun fail(message: String): ApiResponse<ObjectNode> {
            val data = ObjectNode(JsonNodeFactory.instance).put("cause", message)
            return ApiResponse(false, data)
        }
    }
}