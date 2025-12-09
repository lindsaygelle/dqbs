package com.github.lindsaygelle

import kotlinx.serialization.Serializable

@Serializable
enum class Operator {
    EQUAL_TO,
    GREATER_THAN,
    GREATER_THAN_EQUAL_TO,
    LESS_THAN,
    LESS_THAN_EQUAL_TO,
    NOT_EQUAL_TO,
}