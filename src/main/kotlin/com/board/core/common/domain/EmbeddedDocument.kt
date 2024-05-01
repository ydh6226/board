package com.board.core.common.domain

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import java.time.LocalDateTime

abstract class EmbeddedDocument {

    @Id
    val id: String = ObjectId.get().toHexString()

    val createdAt: LocalDateTime = LocalDateTime.now()

    var updatedAt: LocalDateTime = LocalDateTime.now()
}