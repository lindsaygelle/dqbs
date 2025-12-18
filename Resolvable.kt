package com.github.lindsaygelle

interface Resolvable<T : Resolver> {
    fun resolve(resolver: T): Resolution
}
