package com.example.ktl.exception

/**
 * @author : changzhaoliang
 * @date : 2021/6/17 11:42
 * @description :
 */
class KtlException : Exception {
    private var errorCode: Int? = 0

    constructor(message: String, code: Int) : super(message) {
        this.errorCode = code
    }

    constructor(errorStatus: ErrorStatus) : super(errorStatus.message) {
        this.errorCode = errorStatus.code
    }
}