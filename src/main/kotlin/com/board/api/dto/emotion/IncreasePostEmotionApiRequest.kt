package com.board.api.dto.emotion

import com.board.core.emotion.domain.Emotion

data class IncreasePostEmotionApiRequest(
    val userId: String,
    val emotionType: Emotion.Type,
)
