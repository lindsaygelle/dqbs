package com.github.lindsaygelle.dqbs

interface HealInvoker : HealApplier,
    MagicInvoker {
    var healScale: Int
    var healShift: Int
}