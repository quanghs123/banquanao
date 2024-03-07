package com.example.banquanao.domain.service

import com.example.banquanao.domain.factory.UserFactory
import com.example.banquanao.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userFactory: UserFactory
) {
}