package com.example.ktl.persistence.mysql.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.sql.Timestamp

/**
 * @author : changzhaoliang
 * @date : 2021/6/16 18:08
 * @description :
 */
@Table("queen_campus")
data class Campus(
    @Id var id: Long,
    val name: String? = null,
    val displayName: String? = null,
    val schoolId: String? = null,
    val corpId: String? = null,
    val status: Short = 1,
    val version: Long = 0,
    val externalId: String? = null,
    val source: Short = 1,
    val campusHash: String? = null,
    val dateCreated: Timestamp? = null,
    val lastUpdated: Timestamp? = null,
    val nick: String? = null
)
