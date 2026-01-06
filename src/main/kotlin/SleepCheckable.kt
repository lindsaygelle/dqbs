package com.github.lindsaygelle

import java.util.*

class SleepCheckable(magicPoints: Int) : MagicCheckable<SleepInvocation, SleepReception, SleepCheck>(magicPoints),
    MagicPointer {
    override fun check(
        invocation: SleepInvocation, reception: SleepReception
    ): SleepCheck {
        return SleepCheck(
            invocation.magicPoints,
            magicPoints,
            (invocation.sleepRequirement >= reception.sleepResistance) && ((invocation.magicPoints - magicPoints) >= 0),
            System.currentTimeMillis(),
            UUID.randomUUID()
        )
    }
}