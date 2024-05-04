package com.board.core.emotion.domain

import com.board.core.common.domain.BaseEntity
import org.springframework.data.mongodb.core.index.CompoundIndex
import org.springframework.data.mongodb.core.mapping.Document

@Document
@CompoundIndex(def = "{'userId': -1, 'postId': -1, 'emotionType': -1}", unique = true)
data class Emotion(
    val postId: String,
    val userId: String,
    val emotionType: Type,
) : BaseEntity() {

    enum class Type {
        LIKE,
        ;
    }
}
