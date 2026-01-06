package com.github.lindsaygelle

interface HurtInvoker : HurtRanger,
    MagicInvoker {
    var hurtScale: Int
    var hurtShift: Int
}