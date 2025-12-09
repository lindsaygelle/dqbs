package com.github.lindsaygelle

interface AspectContext<K, V : Comparable<V>> {
    var aspect: K
    var aspectValue: V
    var value: V
}