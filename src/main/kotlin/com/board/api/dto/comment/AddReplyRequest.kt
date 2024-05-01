package com.board.api.dto.comment

data class AddReplyRequest(
    val content: String,
    val userId: String,
)
