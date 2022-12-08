package com.example.springevents

import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.AsyncConfigurer
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy

@Configuration
class AsyncConfig(
    private val customExceptionHandler: AsyncExceptionHandler
) : AsyncConfigurer {

    override fun getAsyncExecutor() = ThreadPoolTaskExecutor().apply {
        corePoolSize = Runtime.getRuntime().availableProcessors()
        maxPoolSize = Runtime.getRuntime().availableProcessors() * 5
        queueCapacity = Runtime.getRuntime().availableProcessors() * 10
        setThreadNamePrefix("replacedAsync-")
        setRejectedExecutionHandler(CallerRunsPolicy())
        initialize()
    }

    override fun getAsyncUncaughtExceptionHandler() = customExceptionHandler
}