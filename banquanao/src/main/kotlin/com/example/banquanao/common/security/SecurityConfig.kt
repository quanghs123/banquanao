//package com.example.banquanao.common.security
//
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import org.springframework.security.config.annotation.web.invoke
//import org.springframework.security.web.SecurityFilterChain
//
//
//@Configuration
//@EnableWebSecurity
//class SecurityConfig {
//    @Bean
//    fun filterChain(http: HttpSecurity): SecurityFilterChain{
//        http.invoke {
//            authorizeRequests {
//                authorize(anyRequest, authenticated)
//            }
//            formLogin {  }
//            logout {  }
//        }
//        return http.build()
//    }
//}