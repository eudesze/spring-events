package com.example.springevents

import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.AsyncResult
import org.springframework.stereotype.Component
import java.util.concurrent.Future

@Component
class AsyncMethod {

    @Async
    fun execute() {
        Thread.sleep(5000)

        println("method executed")
    }

    @Async
    fun executeWithError() {
        Thread.sleep(5000)

        throw Exception("Something went wrong")
    }

    @Async
    fun createUser(user: UserCreatedEvent): Future<UserCreatedEvent> {
        Thread.sleep(5000)

        //throw Exception("Something went wrong")

        println("user created")

        return AsyncResult(user)
    }
}