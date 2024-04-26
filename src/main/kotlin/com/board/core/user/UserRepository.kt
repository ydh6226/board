package com.board.core.user

import com.board.core.user.domain.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: MongoRepository<User, String> {
    fun existsByUsername(name: String): Boolean
}