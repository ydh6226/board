package com.board.api

import com.board.api.common.ApiResponse
import com.board.api.dto.SignupRequest
import com.board.core.user.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/users")
@RestController
class UserController(
    private val userService: UserService,
) {

    @PostMapping("/signup")
    fun signup(@RequestBody request: SignupRequest): ApiResponse<Boolean> {
        userService.signup(request.name)
        return ApiResponse.success(true)
    }
}