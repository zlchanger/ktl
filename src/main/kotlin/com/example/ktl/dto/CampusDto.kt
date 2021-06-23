package com.example.ktl.dto

import javax.validation.constraints.NotNull


/**
 * @author : changzhaoliang
 * @date : 2021/6/17 11:28
 * @description :
 */
data class CampusDto(
    @NotNull(message = "{required}")
    val name: String,
    @NotNull(message = "{required}")
    val schoolId: String,
    val nick: String
)
