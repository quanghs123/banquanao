package com.example.banquanao.domain.service

import com.example.banquanao.domain.repository.UserRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(this::class.java.enclosingClass)
    }

    override fun loadUserByUsername(usolId: String): UserDetails {
        val userInfo = userRepository.findUserForLogin(usolId)
        return when (userInfo?.roleName) {
            ApplicationRole.ROLE_USER.toString() -> {
                UserRoleUser(userInfo)
            }

            ApplicationRole.ROLE_ALL_PERMISSIONS.toString() -> {
                AdminRoleUser(userInfo)
            }

            ApplicationRole.ROLE_APPROVE_TIME_RECORD.toString() -> {
                ApproveTimeRecordRoleUser(userInfo)
            }

            ApplicationRole.ROLE_APPROVE_ATTENDANCE_ROLL.toString() -> {
                ApproveAttendanceRoleUser(userInfo)
            }

            ApplicationRole.ROLE_ASSIGNMENT_ROLE.toString() -> {
                AssignmentRoleUser(userInfo)
            }

            else -> throw RuntimeException("[ERROR]: User Role is incorrect.")
        }
    }
}