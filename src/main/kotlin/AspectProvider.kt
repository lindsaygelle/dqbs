package com.github.lindsaygelle

interface AspectProvider<A, T : Comparable<T>> : Identifier {
    fun provideAspect(aspect: A, aspectAsker: AspectAsker): T
}