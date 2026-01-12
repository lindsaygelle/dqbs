package com.github.lindsaygelle

interface AttributeReceiver : Receiver {
    fun getAttribute(attribute: Attribute): Int
}