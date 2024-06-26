package com.board.core.comment.domain

import com.board.core.common.domain.BaseEntity
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Comment(
    val content: String,
    val postId: String,
    val userId: String,
    val username: String,
    val replies: List<Reply> = emptyList(),
) : BaseEntity() {
}
