package com.example.banquanao.presentation.dto

import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull

data class GetAllUserRequestDto (
    @field:NotNull
    @field:NotBlank
    val firstName: String?,
    val lastName: String?
)