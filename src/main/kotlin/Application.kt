package com.github.lindsaygelle

import io.ktor.server.application.*

fun Application.module() {
    configureSerialization()
    configureMonitoring()
    configureHTTP()
    configureRouting()
}
