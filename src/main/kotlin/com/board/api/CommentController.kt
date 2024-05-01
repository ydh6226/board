package com.board.api

import com.board.api.common.ApiResponse
import com.board.api.dto.comment.AddReplyRequest
import com.board.api.dto.comment.CreateCommentRequest
import com.board.api.dto.comment.CreateCommentResponse
import com.board.core.comment.CommentService
import com.board.core.comment.domain.Comment
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/v1/comments")
@RestController
class CommentController(
    private val commentService: CommentService,
) {

    @GetMapping("/{postId}")
    fun getComment(@PathVariable postId: String): ApiResponse<List<Comment>> {
        return ApiResponse.success(commentService.getComment(postId))
    }

    @PostMapping
    fun create(@RequestBody request: CreateCommentRequest): ApiResponse<CreateCommentResponse> {
        val commentId = commentService.createComment(request.userId, request.postId, request.content)
        val response = CreateCommentResponse(commentId)
        return ApiResponse.success(response)
    }

    @PostMapping("/{commentId}/replies")
    fun addReply(@PathVariable commentId: String, @RequestBody request: AddReplyRequest): ApiResponse<Boolean> {
        commentService.addReply(commentId, request.content, request.userId)
        return ApiResponse.success(true)
    }
}