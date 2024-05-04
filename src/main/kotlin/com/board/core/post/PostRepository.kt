package com.board.core.post

import com.board.core.post.domain.Post
import org.springframework.data.mapping.toDotPath
import org.springframework.data.mongodb.core.FindAndModifyOptions
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.stereotype.Repository

@Repository
class PostRepository(
    private val mongoTemplate: MongoTemplate,
    private val postMongoRepository: PostMongoRepository,
) : PostMongoRepository by postMongoRepository {

    fun increaseLikeCount(postId: String, count: Int): Post? {
        return mongoTemplate.findAndModify(
            Query.query(Post::id isEqualTo postId),
            Update().inc(Post::likeCount.toDotPath(), count),
            FindAndModifyOptions.options().returnNew(true),
            Post::class.java
        )
    }
}