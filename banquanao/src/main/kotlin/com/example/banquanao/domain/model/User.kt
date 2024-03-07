package com.example.banquanao.domain.model

import java.time.LocalDateTime
import java.util.UUID

data class User (
    var id: UUID,
    var userName: String,
    var password: String,
    var email: String?,
    var fullName: String,
    var createdBy: String,
    var createdDatetime: LocalDateTime,
    var updatedBy: String,
    var updatedDatetime: LocalDateTime
)