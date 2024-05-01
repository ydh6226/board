package com.board.core.comment

import com.board.core.comment.domain.Comment
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentMongoRepository : MongoRepository<Comment, String> {

    fun findByPostId(postId: String): List<Comment>
}