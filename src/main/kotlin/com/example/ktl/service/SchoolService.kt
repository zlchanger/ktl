package com.example.ktl.service

import com.example.ktl.persistence.mysql.model.School
import com.example.ktl.persistence.mysql.repository.SchoolRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux

/**
 * @author : changzhaoliang
 * @date : 2021/8/2 14:54
 * @description :
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
class SchoolService(
    private val schoolRepository: SchoolRepository
) {
    val log: Logger = LoggerFactory.getLogger(SchoolService::class.java)

    /**
     * school list (low)
     */
    @Transactional(rollbackFor = [Exception::class])
    fun findAllSchool(params: Map<String, Any?>, source: Short, p: Int? = 1, s: Int? = 10): Flux<School> {
        log.info("find all school params ${params}, $source, $p, $s")

        //(replace this with query parameters)
        return schoolRepository.findAll()
            .filter { school ->
                true
////                Optional.ofNullable(params["title"]).map { school.displayName.contains(it, ignoreCase = true) }.orElse(true)
            }
//            .sort(comparing(School::corpId).reversed())
//            .skip(p * s).take(s)
    }

}