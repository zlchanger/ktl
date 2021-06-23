package com.example.ktl.persistence.mysql.repository

import com.example.ktl.persistence.mysql.mapper.CampusMapper
import com.example.ktl.persistence.mysql.model.Campus
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.r2dbc.core.DatabaseClient
import reactor.core.publisher.Flux

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
}

const val selectSizesByProduct = """
//    SELECT sizes.id as size_id, sizes.code as size_code, sizes.sort_order as sort_order
//    FROM queen_campus
//    INNER JOIN product_sizes on sizes.id = product_sizes.size_id
//    WHERE product_sizes.product_id = :productId
"""

class CustomCampusRepositoryImpl(
    private val databaseClient: DatabaseClient,
    private val mapper: CampusMapper
) : CustomCampusRepository {
    override fun findAllBySchoolIdAndStatus(schoolId: String, status: Short): Flux<Campus> {
        return databaseClient.sql(selectSizesByProduct)
            .bind("schoolId", schoolId)
            .bind("status", status)
            .map(mapper::apply)
            .all()
    }

}