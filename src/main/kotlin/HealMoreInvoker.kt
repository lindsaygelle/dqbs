package com.github.lindsaygelle

interface HealMoreInvoker : HealRanger,
    MagicInvoker {
    var healMoreScale: Int
    var healMoreShift: Int
}