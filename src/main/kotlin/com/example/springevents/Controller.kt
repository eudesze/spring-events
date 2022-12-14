package com.example.springevents

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(
    val publisher: Publisher,
    val asyncMethod: AsyncMethod
) {

    @PostMapping("/users/event")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody user: UserCreatedEvent): UserCreatedEvent {
        publisher.publishEvent(user)

        return user
    }

    @GetMapping("/async")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun async() {
        asyncMethod.execute()
    }

    @GetMapping("/async/error")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun asyncWithError() {
        asyncMethod.executeWithError()
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    fun asyncPost(@RequestBody user: UserCreatedEvent): UserCreatedEvent {

        val userCreated = asyncMethod.createUser(user)

        return userCreated.get()
    }
}