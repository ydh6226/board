package com.board.api

import com.board.api.common.ApiResponse
import com.board.api.dto.comment.CreateCommentRequest
import com.board.api.dto.comment.CreateCommentResponse
import com.board.core.comment.CommentService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/comments")
@RestController
class CommentController(
    private val commentService: CommentService,
) {

    @PostMapping
    fun create(@RequestBody request: CreateCommentRequest): ApiResponse<CreateCommentResponse> {
        val commentId = commentService.createComment(request.userId, request.postId, request.content)
        val response = CreateCommentResponse(commentId)
        return ApiResponse.success(response)
    }
}