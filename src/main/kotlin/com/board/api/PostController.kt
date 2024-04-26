package com.board.api

import com.board.api.common.ApiResponse
import com.board.api.dto.post.CreatePostApiRequest
import com.board.api.dto.post.CreatePostApiResponse
import com.board.api.dto.post.GetPostApiResponse
import com.board.core.post.PostService
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/v1/posts")
@RestController
class PostController(
    private val postService: PostService,
) {

    @GetMapping("/{postId}")
    fun getPost(@PathVariable postId: String): ApiResponse<GetPostApiResponse> {
        val postDto = postService.getPostById(postId)
        val response = GetPostApiResponse(postDto)
        return ApiResponse.success(response)
    }

    @PostMapping("/create")
    fun createPost(@RequestBody request: CreatePostApiRequest): ApiResponse<CreatePostApiResponse> {
        val postId = postService.createPost(request.userId, request.title, request.content)
        val response = CreatePostApiResponse(postId)
        return ApiResponse.success(response)
    }

}