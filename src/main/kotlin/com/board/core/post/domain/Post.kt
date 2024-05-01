package com.board.core.post.domain

import com.board.core.common.exception.BaseEntity
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Post(
    val userId: String,
    val username: String,
    var title: String,
    var content: String,
) : BaseEntity() {

    init {
        require(title.isNotBlank()) { "title must not be blank" }
        require(content.isNotBlank()) { "content must not be blank" }
    }

}