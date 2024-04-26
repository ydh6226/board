package com.board.api

import com.board.api.common.ApiResponse
import com.board.api.dto.user.SignupApiRequest
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
    fun signup(@RequestBody request: SignupApiRequest): ApiResponse<Boolean> {
        userService.signup(request.name)
        return ApiResponse.success(true)
    }
}