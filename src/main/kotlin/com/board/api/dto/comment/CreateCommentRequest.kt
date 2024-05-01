package com.board.api.dto.comment

data class CreateCommentRequest(
    val content: String,
    val postId: String,
    val userId: String,
)
