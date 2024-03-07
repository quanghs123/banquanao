package com.example.banquanao.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "category")
data class CategoryEntity (
    @Id
    @Column(name = "id")
    val id: UUID,
    @Column(name = "category_name", length = 200, nullable = false)
    val categoryName: String,
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