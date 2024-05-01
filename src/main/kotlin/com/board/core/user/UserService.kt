package com.board.core.user

import com.board.core.common.exception.BadRequestException
import com.board.core.user.domain.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository
) {

    @Transactional
    fun signup(name: String) {
        if (userRepository.existsByUsername(name)) {
            throw BadRequestException("이미 존재하는 사용자입니다.")
        }

        val user = User(name)
        userRepository.save(user)
    }

    fun getUser(userId: String): User {
        return userRepository.findById(userId).orElseThrow { BadRequestException("사용자를 찾을 수 없습니다. userId: $userId") }
    }

    fun getUsername(userId: String): String {
        return getUser(userId).username
    }
}