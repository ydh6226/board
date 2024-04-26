package com.board.core.post

import com.board.core.post.domain.Post
import com.board.core.post.dto.PostDto
import com.board.core.user.UserService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PostService(
    private val userService: UserService,
    private val postRepository: PostRepository,
) {

    fun createPost(
        userId: String,
        title: String,
        content: String
    ): String {
        require(userService.existsByUserId(userId)) { "User not found. userId: $userId" }

        val post = Post(userId, title, content)
        postRepository.save(post)
        return post.id!!
    }

    fun getPostById(id: String): PostDto {
        val post = postRepository.findByIdOrNull(id) ?: throw IllegalArgumentException("Post not found")
        return PostDto.from(post)
    }
}