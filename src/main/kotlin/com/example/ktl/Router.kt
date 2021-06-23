package com.example.ktl

import com.example.ktl.handler.CampusHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

/**
 * @author : changzhaoliang
 * @date : 2021/6/23 15:42
 * @description :
 */
@Configuration
class Router(private val campusHandler: CampusHandler) {
    @Bean("routes")
    fun routes(): RouterFunction<ServerResponse> {
        return router {
            POST("/campus", campusHandler::save)
            GET("/campus", campusHandler::index)
        }
    }
}