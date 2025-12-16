package com.github.lindsaygelle

interface AbilityContext : Context {
    val invokerContext: Context
    val receiverContext: Context
}