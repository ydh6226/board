package com.board.core.emotion

import com.board.core.emotion.domain.Emotion
import org.springframework.data.mongodb.repository.MongoRepository

interface EmotionRepository : MongoRepository<Emotion, String> {
}