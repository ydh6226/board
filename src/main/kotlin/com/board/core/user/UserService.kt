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
        if (userRepository.existsByName(name)) {
            throw BadRequestException("이미 존재하는 사용자입니다.")
        }

        val user = User(name)
        userRepository.save(user)
    }
}