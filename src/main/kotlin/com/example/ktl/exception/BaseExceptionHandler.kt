package com.example.ktl.exception

import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * @author : changzhaoliang
 * @date : 2021/6/17 12:41
 * @description :
 */
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
class BaseExceptionHandler {

    @ExceptionHandler(value = [Exception::class])
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(e: Exception) {
//        val message = if (CommonUtils.containChinese(e.message)) e.message else "系统内部异常"
//        log.error(message, e)
//        return ResultVM.failure(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message)
    }

    @ExceptionHandler(value = [KtlException::class])
    @ResponseStatus(HttpStatus.OK)
    fun handleQueenException(e: KtlException) {
//        log.info("自定义queen异常 code: {}, message:{}", e.getErrorCode(), e.getMessage())
//        return ResultVM.failure(e.getErrorCode(), e.getMessage())
    }
}