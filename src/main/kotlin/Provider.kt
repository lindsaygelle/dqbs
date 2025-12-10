package com.github.lindsaygelle

interface Provider : Identifier {
    fun provide(attribute: Attribute, requester: Requester): Int
}
