package com.example.springevents

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler
import org.springframework.stereotype.Component
import java.lang.reflect.Method

@Component
class AsyncExceptionHandler : AsyncUncaughtExceptionHandler {
    override fun handleUncaughtException(ex: Throwable, method: Method, vararg params: Any?) = runCatching {
        println("[Exception-Async-Handler]")
        println("Class Name: ${method.declaringClass.name}")
        println("Method Name: ${method.name}")
        println("Exception: ${ex::class.java.name}")
        println("Message: ${ex.message}")
    }.getOrElse {
        println("catch Async Exception: $it")
    }
}