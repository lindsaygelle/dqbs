package com.github.lindsaygelle

interface Ticker<T : Context> {
    fun tick(): T
}
