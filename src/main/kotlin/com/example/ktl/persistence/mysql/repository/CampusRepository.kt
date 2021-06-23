package com.example.ktl.persistence.mysql.repository

import com.example.ktl.persistence.mysql.mapper.CampusMapper
import com.example.ktl.persistence.mysql.model.Campus
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.r2dbc.core.bind
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * @author : changzhaoliang
 * @date : 2021/6/16 18:49
 * @description :
 */
interface CampusRepository : R2dbcRepository<Campus, Long>, CustomCampusRepository {

    fun findAllBySchoolIdAndSource(schoolId: String, source: Short): Flux<Campus>
}

interface CustomCampusRepository {
    fun findAllBySchoolIdAndStatus(schoolId: String, status: Short): Flux<Campus>

    fun deleteAllBySchoolId(schoolId: String): Mono<Int>

    fun insertCampus(campus: Campus): Mono<Campus>
}

const val selectSizesByProduct = """
//    SELECT sizes.id as size_id, sizes.code as size_code, sizes.sort_order as sort_order
//    FROM queen_campus
//    INNER JOIN product_sizes on sizes.id = product_sizes.size_id
//    WHERE product_sizes.product_id = :productId
"""

const val deleteAllBySchoolId = """
    UPDATE queen_campus SET status = 0 WHERE school_id = :schoolId and status = 1
"""

const val insertCampus = """
    INSERT INTO queen_campus (name, display_name, school_id, status, version, external_id, source, campus_hash, date_created, last_updated) VALUES (:name, :displayName, :schoolId, 1, 0, :externalId, :source, :campusHash, :dateCreated, :lastUpdated)
"""

class CustomCampusRepositoryImpl(
    private val databaseClient: DatabaseClient,
    private val mapper: CampusMapper
) : CustomCampusRepository {
    override fun findAllBySchoolIdAndStatus(schoolId: String, status: Short): Flux<Campus> =
        databaseClient.sql(selectSizesByProduct)
            .bind("schoolId", schoolId)
            .bind("status", status)
            .map(mapper::apply)
            .all()

    override fun deleteAllBySchoolId(schoolId: String): Mono<Int> =
        databaseClient.sql(deleteAllBySchoolId)
            .bind("schoolId", schoolId)
            .fetch().rowsUpdated()

    override fun insertCampus(campus: Campus): Mono<Campus> =
        databaseClient.sql(insertCampus)
            .filter { statement, _ -> statement.returnGeneratedValues("id").execute() }
            .bind("name", campus.name)
            .bind("displayName", campus.name)
            .bind("schoolId", campus.schoolId)
            .bind("externalId", campus.externalId)
            .bind("source", campus.source)
            .bind("campusHash", campus.campusHash)
            .bind("dateCreated", campus.dateCreated)
            .bind("lastUpdated", campus.dateCreated)
            .fetch()
            .first()
            .map { campus.copy(id = it["id"] as Long) }
}