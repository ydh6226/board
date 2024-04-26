package com.board.api.common


class ApiResponse<T>(
    val success: Boolean,
    val data: T,
) {
    companion object {
        fun <T> success(data: T): ApiResponse<T> {
            return ApiResponse(true, data)
        }

        fun fail(message: String): ApiResponse<String> {
            return ApiResponse(false, message)
        }
    }
}