package com.example.ktl.service

import com.example.ktl.persistence.mysql.model.Campus
import com.example.ktl.persistence.mysql.repository.CampusRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.OffsetDateTime

/**
 * @author : changzhaoliang
 * @date : 2021/6/17 14:30
 * @description :
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
class CampusService(
    private val campusRepository: CampusRepository
) {
    val log: Logger = LoggerFactory.getLogger(CampusService::class.java)

    fun findAllCampusBySchoolIdAndSource(schoolId: String, source: Short): Flux<Campus> =
        campusRepository.findAllBySchoolIdAndSource(schoolId, source)

    @Transactional(rollbackFor = [Exception::class])
    fun createCampus(name: String, schoolId: String, source: Short, nick: String? = null): Mono<Campus> {

        log.info("campus create ${name}, ${schoolId}, ${source}, ${nick}")

        val campus = Campus(
            name = name, displayName = name, schoolId = schoolId, corpId = schoolId,
            externalId = "1", source = source, campusHash = "1-1", dateCreated = OffsetDateTime.now(),
            lastUpdated = OffsetDateTime.now(), nick = nick
        )

        return campusRepository.save(campus)
    }

//    fun pageAllCampusBySchoolIdAndSource(): Flux<Campus> {
//
//    }
}