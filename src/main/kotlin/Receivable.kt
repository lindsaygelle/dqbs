package com.github.lindsaygelle

abstract class Receivable<T: Receiver> {
    abstract fun receive(receiver: T): Reception
}
