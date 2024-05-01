package com.board.core.comment.domain

import com.board.core.common.domain.EmbeddedDocument

data class Reply(
    val content: String,
    val userId: String,
    val username: String,
) : EmbeddedDocument() {
}