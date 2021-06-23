package com.example.ktl.exception

import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import javax.validation.ConstraintViolation
import javax.validation.ConstraintViolationException
import javax.validation.Validator

/**
 * @author : changzhaoliang
 * @date : 2021/6/22 19:00
 * @description :
 */
@Component
class RequestValidator(private val validator: Validator) {

    fun <T> validate(obj: T): Mono<T> {
        obj ?: return Mono.error<T>(IllegalArgumentException())
        val violations: Set<ConstraintViolation<T>>? = validator.validate<T>(obj)
        return if (violations == null || violations.isEmpty()) {
            Mono.just<T>(obj)
        } else Mono.error(ConstraintViolationException(violations))
    }
}