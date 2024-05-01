package com.board.core.common.domain

import org.bson.types.ObjectId
import java.time.LocalDateTime

abstract class EmbeddedDocument {
    var id: String = ObjectId.get().toHexString()
        private set

    var createdAt: LocalDateTime = LocalDateTime.now()
        private set

    var updatedAt: LocalDateTime = LocalDateTime.now()
}