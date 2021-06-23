package com.example.ktl.handler

import com.example.ktl.dto.CampusDto
import com.example.ktl.exception.RequestValidator
import com.example.ktl.service.CampusService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

/**
 * @author : changzhaoliang
 * @date : 2021/6/17 15:11
 * @description :
 */
@Component
class CampusHandler(
    private val campusService: CampusService,
    private val validator: RequestValidator
) {

    fun save(request: ServerRequest): Mono<ServerResponse> =
        request.bodyToMono<CampusDto>().map {
            validator.validate(it)
        }.map { m ->
            m.flatMap { campusService.createCampus(it.name, it.schoolId, 1, it.nick) }
        }.flatMap {
            ok().json().body(it)
        }

    fun index(request: ServerRequest): Mono<ServerResponse> =
        request.toMono().map {
            it.queryParamOrNull("schoolId")?.let { it1 -> campusService.findAllCampusBySchoolIdAndSource(it1, 1) }
        }.flatMap {
            ok().json().body(it)
        }
}