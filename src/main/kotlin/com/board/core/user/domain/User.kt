package com.board.core.user.domain

import com.board.core.common.exception.BaseEntity
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(
    val username: String,
) : BaseEntity() {

    init {
        require(username.isNotBlank()) { "username must not be blank" }
    }

}

