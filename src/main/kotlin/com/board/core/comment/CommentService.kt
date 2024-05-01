package com.board.core.comment

import com.board.core.comment.domain.Comment
import com.board.core.comment.domain.Reply
import com.board.core.post.PostRepository
import com.board.core.user.UserService
import org.springframework.stereotype.Service

@Service
class CommentService(
    private val userService: UserService,
    private val postRepository: PostRepository,
    private val commentRepository: CommentRepository,
) {
    fun getComment(postId: String): List<Comment> {
        return commentRepository.findByPostId(postId)
    }

    fun createComment(
        userId: String,
        postId: String,
        content: String
    ): String {
        require(isPostExists(postId)) { "존재하지 않는 게시글입니다. postId: $postId" }

        val username = userService.getUsername(userId)
        val comment = Comment(content, postId, userId, username)

        return commentRepository.save(comment).id!!
    }

    fun addReply(
        commentId: String,
        content: String,
        userId: String,
    ) {
        require(isCommentExists(commentId)) { "존재하지 않는 댓글입니다. commentId: $commentId" }

        val username = userService.getUsername(userId)
        val reply = Reply(content, userId, username)

        commentRepository.addReply(commentId, reply)
    }

    private fun isPostExists(postId: String): Boolean {
        // 'Executing count' 쿼리로 나가네?
        return postRepository.existsById(postId)
    }

    private fun isCommentExists(commentId: String): Boolean {
        return commentRepository.existsById(commentId)
    }
}