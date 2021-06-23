package com.example.ktl.configuration

import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.r2dbc.connection.R2dbcTransactionManager
import org.springframework.transaction.ReactiveTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement

/**
 * @author : changzhaoliang
 * @date : 2021/6/23 17:27
 * @description :
 */
@Configuration
@EnableTransactionManagement
class DatabaseConfiguration {
    @Bean
    fun transactionManager(connectionFactory: ConnectionFactory):
            ReactiveTransactionManager {
        return R2dbcTransactionManager(connectionFactory)
    }
}