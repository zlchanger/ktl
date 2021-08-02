package com.example.ktl.persistence.mysql.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.OffsetDateTime

/**
 * @author : changzhaoliang
 * @date : 2021/6/16 17:36
 * @description :
 */
@Table("school")
data class School(
    @Id val id: Long? = null,
    val name: String? = null,
    val displayName: String? = null,
    val status: Short = 1,
    val version: Long = 0,
    val corpId: String? = null,
    val externalId: String? = null,
    val source: Short = 1,
    val schoolHash: String? = null,
    val lastUpdated: OffsetDateTime? = null,
    val dateCreated: OffsetDateTime? = null
)