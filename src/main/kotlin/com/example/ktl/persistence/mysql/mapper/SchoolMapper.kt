package com.example.ktl.persistence.mysql.mapper

import com.example.ktl.persistence.mysql.model.School
import io.r2dbc.spi.Row
import org.springframework.stereotype.Component
import java.sql.Timestamp
import java.util.function.BiFunction

/**
 * @author : changzhaoliang
 * @date : 2021/6/16 18:35
 * @description :
 */
@Component
class SchoolMapper : BiFunction<Row, Any, School> {
    override fun apply(t: Row, u: Any): School {
        return School(
            t.get("id", Number::class.java)?.toLong() ?: throw Exception(),
            t.get("name", String::class.java) ?: throw Exception(),
            t.get("display_name", String::class.java) ?: throw Exception(),
            t.get("status", Number::class.java)?.toShort() ?: throw Exception(),
            t.get("id", Number::class.java)?.toLong() ?: throw Exception(),
            t.get("corp_id", String::class.java) ?: throw Exception(),
            t.get("external_id", String::class.java) ?: throw Exception(),
            t.get("source", Number::class.java)?.toShort() ?: throw Exception(),
            t.get("school_hash", String::class.java) ?: throw Exception(),
            t.get("last_updated", Timestamp::class.java) ?: throw Exception(),
            t.get("date_created", Timestamp::class.java) ?: throw Exception(),
        )
    }
}