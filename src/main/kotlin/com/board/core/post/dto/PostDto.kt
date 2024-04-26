package com.board.core.post.dto

import com.board.core.post.domain.Post
import java.time.LocalDateTime

data class PostDto(
    val id: String,
    val title: String,
    val content: String,
    val createdAt: LocalDateTime,
) {
    companion object {
        fun from(post: Post): PostDto {
            return PostDto(
                id = post.id!!,
                title = post.title,
                content = post.content,
                createdAt = post.createdAt!!,
            )
        }
    }
}

