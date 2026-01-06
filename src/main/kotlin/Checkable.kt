package com.github.lindsaygelle

abstract class Checkable<A : Invoker, B : Receiver> {
    abstract fun check(invocable: Invocable<A>, receivable: Receivable<B>): Check
}