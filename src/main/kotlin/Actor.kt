package com.github.lindsaygelle

interface Actor : ActionReceiver,
    Actioner,
    Indexable,
    MagicPointPercenter,
    Nameable {
    fun act(receivers: List<ActionReceiver>)
}