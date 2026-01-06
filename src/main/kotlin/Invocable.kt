package com.github.lindsaygelle

abstract class Invocable<T : Invoker> {
    abstract fun invoke(invoker: T): Invocation
}
