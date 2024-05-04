package com.board.core.user.domain

import com.board.core.common.domain.BaseEntity
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(
    @Indexed(unique = true)
    val username: String,
) : BaseEntity() {

    init {
        require(username.isNotBlank()) { "username must not be blank" }
    }

}

