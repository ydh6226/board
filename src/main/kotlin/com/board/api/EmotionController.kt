package com.board.api

import com.board.api.common.ApiResponse
import com.board.api.dto.emotion.IncreasePostEmotionApiRequest
import com.board.api.dto.emotion.IncreasePostEmotionApiResponse
import com.board.core.emotion.EmotionService
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/v1/emotions")
@RestController
class EmotionController(
    private val emotionService: EmotionService,
) {

    @PostMapping("/posts/{postId}/increase")
    fun createPost(
        @PathVariable postId: String,
        @RequestBody request: IncreasePostEmotionApiRequest
    ): ApiResponse<IncreasePostEmotionApiResponse> {
        val updatedCount = emotionService.increaseEmotion(postId, request.userId, request.emotionType)
        val response = IncreasePostEmotionApiResponse(updatedCount)
        return ApiResponse.success(response)
    }
}