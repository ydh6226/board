package com.board.core.comment

import com.board.core.comment.domain.Comment
import com.board.core.comment.domain.Reply
import org.springframework.data.mapping.toDotPath
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Update
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.stereotype.Repository

@Repository
class CommentRepository(
    private val mongoTemplate: MongoTemplate,
    private val commentMongoRepository: CommentMongoRepository,
) : CommentMongoRepository by commentMongoRepository {

    fun addReply(commentId: String, reply: Reply) {
        mongoTemplate.update(Comment::class.java)
            .matching(Comment::id isEqualTo commentId)
            .apply(Update().push(Comment::replies.toDotPath(), reply))
            .first()
    }
}
