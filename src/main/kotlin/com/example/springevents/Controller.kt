package com.example.springevents

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(
    val publisher: Publisher
) {

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    fun create(@RequestBody user: UserCreatedEvent): UserCreatedEvent {
        publisher.publishEvent(user)

        return user
    }
}