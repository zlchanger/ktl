package com.example.ktl.dto.mapper

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * @author : changzhaoliang
 * @date : 2021/6/17 12:35
 * @description :
 */
interface DTOMapper<D, M> {
    fun toDTOs(models: Flux<M>): Flux<D>
    fun toModels(dtos: Flux<D>): Flux<M>

    fun toDTO(model: Mono<M>): Mono<D>
    fun toModel(dto: Mono<D>): Mono<M>
}