package com.example.ktl.persistence.mysql.mapper

import com.example.ktl.persistence.mysql.model.Campus
import io.r2dbc.spi.Row
import java.sql.Timestamp
import java.util.function.BiFunction

/**
 * @author : changzhaoliang
 * @date : 2021/6/16 18:45
 * @description :
 */
class CampusMapper : BiFunction<Row, Any, Campus> {
    override fun apply(t: Row, u: Any): Campus {
        return Campus(
            t.get("id", Number::class.java)?.toLong() ?: throw Exception(),
            t.get("name", String::class.java) ?: throw Exception(),
            t.get("display_name", String::class.java) ?: throw Exception(),
            t.get("school_id", String::class.java) ?: throw Exception(),
            t.get("corp_id", String::class.java) ?: throw Exception(),
            t.get("status", Number::class.java)?.toShort() ?: throw Exception(),
            t.get("version", Number::class.java)?.toLong() ?: throw Exception(),
            t.get("external_id", String::class.java) ?: throw Exception(),
            t.get("source", Number::class.java)?.toShort() ?: throw Exception(),
            t.get("campus_hash", String::class.java) ?: throw Exception(),
            t.get("last_updated", Timestamp::class.java) ?: throw Exception(),
            t.get("date_created", Timestamp::class.java) ?: throw Exception(),
            t.get("nick", String::class.java) ?: throw Exception()
        )
    }
}