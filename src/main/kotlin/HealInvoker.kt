package com.github.lindsaygelle

interface HealInvoker : HealRanger,
    MagicInvoker {
    var healScale: Int
    var healShift: Int
}