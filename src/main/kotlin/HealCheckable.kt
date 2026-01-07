package com.github.lindsaygelle

import java.util.*

class HealCheckable(magicPoints: Int) : MagicCheckable<HealInvocation, HealReception, HealCheck>(magicPoints) {
    override fun check(
        invocation: HealInvocation,
        reception: HealReception
    ): HealCheck {
        return HealCheck(
            invocation.heal,
            invocation.magicPoints,
            magicPoints,
            System.currentTimeMillis(),
            UUID.randomUUID(),
        )
    }
}