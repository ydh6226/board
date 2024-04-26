package com.board.core.user.domain

import com.board.core.common.exception.BaseEntity
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(
    val name: String,
) : BaseEntity() {

    init {
        require(name.isNotBlank()) { "name must not be blank" }
    }

}

