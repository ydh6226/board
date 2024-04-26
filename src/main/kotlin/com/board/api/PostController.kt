package com.board.api

import com.board.api.common.ApiResponse
import com.board.api.dto.post.CreatePostApiRequest
import com.board.api.dto.post.CreatePostApiResponse
import com.board.core.post.PostService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/posts")
@RestController
class PostController(
    private val postService: PostService,
) {

    @PostMapping("/create")
    fun createPost(@RequestBody request: CreatePostApiRequest): ApiResponse<CreatePostApiResponse> {
        val postId = postService.createPost(request.userId, request.title, request.content)
        val response = CreatePostApiResponse(postId)
        return ApiResponse.success(response)
    }

}