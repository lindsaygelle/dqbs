package com.github.lindsaygelle.dqbs

interface HealMoreInvoker : HealApplier,
    MagicInvoker {
    var healMoreScale: Int
    var healMoreShift: Int
}