package com.example.banquanao.persistence.repository

import com.example.banquanao.persistence.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserEntityRepository: JpaRepository<UserEntity, UUID> {
}