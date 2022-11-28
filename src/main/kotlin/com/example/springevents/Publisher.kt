package com.example.springevents

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class Publisher(
    val publisher: ApplicationEventPublisher
) {

    fun publishEvent(user: UserCreatedEvent) {
        publisher.publishEvent(user)
    }
}