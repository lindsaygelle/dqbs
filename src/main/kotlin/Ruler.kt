package com.github.lindsaygelle

interface Ruler<T : AttributeReceiver> {
    var rules: List<Rule<T>>
}