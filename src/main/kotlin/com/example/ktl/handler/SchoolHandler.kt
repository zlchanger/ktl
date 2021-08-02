package com.example.ktl.handler

import com.example.ktl.exception.RequestValidator
import org.springframework.stereotype.Component

/**
 * @author : changzhaoliang
 * @date : 2021/8/2 14:53
 * @description :
 */
@Component
class SchoolHandler(
    private val requestValidator: RequestValidator
) {
}