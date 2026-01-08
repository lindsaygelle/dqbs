package com.github.lindsaygelle

import java.util.*

class HurtCheckable(magicPoints: Int) : MagicCheckable<HurtInvocation, HurtReception, HurtCheck>(magicPoints) {
    override fun check(
        invocation: HurtInvocation,
        reception: HurtReception
    ): HurtCheck {
        return HurtCheck(
            invocation.hurtRequirement,
            reception.hurtResistance,
            invocation.magicPoints,
            magicPoints,
            System.currentTimeMillis(),
            UUID.randomUUID()
        )
    }
}