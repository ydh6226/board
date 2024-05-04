package com.board.core.emotion

import com.board.core.common.exception.BadRequestException
import com.board.core.emotion.domain.Emotion
import com.board.core.post.PostService
import org.springframework.dao.DuplicateKeyException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EmotionService(
    private val emotionRepository: EmotionRepository,
    private val postService: PostService,
) {

    /**
     * @return updated count
     */
    @Transactional
    fun increaseEmotion(postId: String, userId: String, emotionType: Emotion.Type): Long {
        val emotion = Emotion(postId, userId, emotionType)
        saveEmotion(emotion)

        return when (emotionType) {
            Emotion.Type.LIKE -> postService.increaseLikeCount(postId)
        }
    }

    private fun saveEmotion(emotion: Emotion) {
        try {
            emotionRepository.save(emotion)
        } catch (e: DuplicateKeyException) {
            throw BadRequestException("이미 처리한 감정표현입니다.")
        }
    }
}