package com.github.lindsaygelle.dqbs

interface Checker<R : Receiver> {
    fun check(
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ): Boolean
}