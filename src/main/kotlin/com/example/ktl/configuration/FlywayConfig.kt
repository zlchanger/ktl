package com.example.ktl.configuration

import org.flywaydb.core.Flyway
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment


/**
 * @author : changzhaoliang
 * @date : 2021/8/2 14:38
 * @description :
 */
@Configuration
class FlywayConfig(var env: Environment) {

    @Bean(initMethod = "migrate")
    fun flyway(): Flyway? {
        return Flyway(
            Flyway.configure()
                .baselineOnMigrate(true)
                .dataSource(
                    env.getRequiredProperty("spring.flyway.url"),
                    env.getRequiredProperty("spring.flyway.user"),
                    env.getRequiredProperty("spring.flyway.password")
                )
        )
    }
}