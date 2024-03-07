package com.example.banquanao.domain.repository

import com.example.banquanao.domain.factory.UserFactory
import com.example.banquanao.persistence.repository.UserEntityRepository
import org.springframework.stereotype.Repository

@Repository
class UserRepository(
    private val userRepository: UserEntityRepository,
    private val userFactory: UserFactory
) {

}