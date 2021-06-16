package com.example.ktl.persistence.mysql.repository

import com.example.ktl.persistence.mysql.model.School
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

/**
 * @author : changzhaoliang
 * @date : 2021/6/16 18:43
 * @description :
 */
interface SchoolRepository : ReactiveCrudRepository<School, Long> {}

interface CustomSchoolRepository {
    fun findByProduct(productId: Int): Flux<School>
}