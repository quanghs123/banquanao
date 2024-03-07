package com.example.banquanao.persistence.entity

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "user")
data class UserEntity (
    @Id
    @Column(name = "id")
    val id: UUID,
    @Column(name = "user_name", length = 10, nullable = false)
    val userName: String,
    @Column(name = "password", length = 10, nullable = false)
    val password: String,
    @Column(name = "email", length = 50, nullable = true)
    val email: String?,
    @Column(name = "full_name", length = 50, nullable = false)
    val fullName: String,
    @Column(name = "logical_delete_flag", length = 1, nullable = false)
    val logicalDeleteFlag: String,
    @Column(name = "created_by", length = 200, nullable = false)
    val createdBy: String,
    @Column(name = "created_datetime", nullable = false)
    val createdDatetime: LocalDateTime,
    @Column(name = "updated_by", length = 200, nullable = false)
    val updatedBy: String,
    @Column(name = "updated_datetime", nullable = false)
    val updatedDatetime: LocalDateTime,
)