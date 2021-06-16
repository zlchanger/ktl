package com.example.ktl.persistence.mysql.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.sql.Timestamp

/**
 * @author : changzhaoliang
 * @date : 2021/6/16 17:36
 * @description :
 */
@Table("queen_school")
data class School(
    @Id var id: Long,
    var name: String? = null,
    var displayName: String? = null,
    var status: Short = 1,
    var version: Long = 0,
    var corpId: String? = null,
    var externalId: String? = null,
    var source: Short = 1,
    var schoolHash: String? = null,
    var lastUpdated: Timestamp? = null,
    var dateCreated: Timestamp? = null
)