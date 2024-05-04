package com.board.core.post

import com.board.core.post.domain.Post
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PostMongoRepository : MongoRepository<Post, String> {
}