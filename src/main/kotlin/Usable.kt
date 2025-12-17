package com.github.lindsaygelle

interface Usable<A : Invoker, B : Receiver, C : Context> {
    fun use(invoker: A, receivers: List<B>): C
}
