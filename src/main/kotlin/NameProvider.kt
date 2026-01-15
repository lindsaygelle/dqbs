package com.github.lindsaygelle.dqbs

interface NameProvider {
    val name: String
        get() = javaClass.simpleName
}