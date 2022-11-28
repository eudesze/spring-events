package com.example.springevents

import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class UserAddedListener {

    @Async
    @EventListener
    //@EventListener(condition = "#user.name eq 'test'")
    fun handleEvent(user: UserCreatedEvent) {
        Thread.sleep(5000)

        println(user)
    }
}