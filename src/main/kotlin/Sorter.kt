package com.github.lindsaygelle.dqbs

interface Sorter<R : Receiver> {
    fun sort(
        receivers: Collection<R>,
        tracers: MutableCollection<Tracer>,
    ): List<R>
}