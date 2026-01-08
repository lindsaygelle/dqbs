package com.github.lindsaygelle

interface HurtMoreInvoker : HurtRanger,
    HurtRequirer,
    MagicInvoker {
    var hurtMoreScale: Int
    var hurtMoreShift: Int
}