package com.example.ktl.exception

/**
 * @author : changzhaoliang
 * @date : 2021/6/17 12:09
 * @description :
 */
enum class ErrorStatus(var code: Int, var message: String) {

    DATA_NOT_EXIST(900000, "该数据不存在"),
    AUTH_CHECK_ERROR(900001, "没有对应权限"),
    DATA_BASE_DATA_ERROR(900002, "数据库data字段异常");

    companion object {
        fun from(c: Int, m: String): ErrorStatus = ErrorStatus.values().first { it.code == c && it.message == m }
    }
}