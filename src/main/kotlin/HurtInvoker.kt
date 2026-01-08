package com.github.lindsaygelle

interface HurtInvoker : HurtRanger,
    HurtRequirer,
    MagicInvoker {
    var hurtScale: Int
    var hurtShift: Int
}