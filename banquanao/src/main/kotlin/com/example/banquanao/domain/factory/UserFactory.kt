package com.example.banquanao.domain.factory

import com.example.banquanao.persistence.entity.UserEntity
import com.example.banquanao.domain.model.User
import org.springframework.stereotype.Component

@Component
class UserFactory {
    fun createModelFromEntity(userEntity: UserEntity): User {
        return User(
            id = userEntity.id,
            userName = userEntity.userName,
            password = userEntity.password,
            email = userEntity.email,
            fullName = userEntity.fullName,
            createdBy = userEntity.createdBy,
            createdDatetime = userEntity.createdDatetime,
            updatedBy = userEntity.updatedBy,
            updatedDatetime = userEntity.updatedDatetime
        )
    }

    fun createEntityFromModel(user: User): UserEntity {
        return UserEntity(
            id = user.id,
            userName = user.userName,
            password = user.password,
            email = user.email,
            fullName = user.fullName,
            createdBy = user.createdBy,
            createdDatetime = user.createdDatetime,
            updatedBy = user.updatedBy,
            updatedDatetime = user.updatedDatetime
        )
    }
}