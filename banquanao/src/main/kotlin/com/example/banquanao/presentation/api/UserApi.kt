package com.example.banquanao.presentation.api

import com.example.banquanao.domain.service.UserService
import com.example.banquanao.presentation.dto.GetAllUserRequestDto
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class UserApi(
    private val userService: UserService
) {
    @PostMapping("/hello")
    fun helloWord(
        @RequestBody
        @Valid
        request: GetAllUserRequestDto
    ): String {
        return "Hello world! ${request.firstName + request.lastName}"
    }
}