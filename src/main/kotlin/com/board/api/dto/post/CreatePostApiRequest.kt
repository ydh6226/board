package com.board.api.dto.post

data class CreatePostApiRequest(
    val userId: String,
    val title: String,
    val content: String,
)
