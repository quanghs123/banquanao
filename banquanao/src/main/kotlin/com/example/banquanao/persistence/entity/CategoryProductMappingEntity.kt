package com.example.banquanao.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "category_product_mapping")
data class CategoryProductMappingEntity(
    @Id
    @Column(name = "id")
    val id: UUID,
    @Column(name = "category_id", length = 200, nullable = false)
    val categoryId: UUID,
    @Column(name = "product_id", length = 200, nullable = false)
    val productId: UUID,
    @Column(name = "created_by", length = 200, nullable = false)
    val createdBy: String,
    @Column(name = "created_datetime", nullable = false)
    val createdDatetime: LocalDateTime,
    @Column(name = "updated_by", length = 200, nullable = false)
    val updatedBy: String,
    @Column(name = "updated_datetime", nullable = false)
    val updatedDatetime: LocalDateTime,
)