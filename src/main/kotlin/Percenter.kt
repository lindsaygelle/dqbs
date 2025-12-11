package com.github.lindsaygelle

interface Percenter {
    fun getPercentage(value: Int, valueMaximum: Int): Int {
        return ((value.toDouble() / valueMaximum.toDouble()) * 100).toInt()
    }
}