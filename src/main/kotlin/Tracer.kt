package com.github.lindsaygelle.dqbs

import java.util.*

interface Tracer {
    val timeMilliseconds: Long
    val uuid: UUID
}