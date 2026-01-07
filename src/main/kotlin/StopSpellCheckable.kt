package com.github.lindsaygelle

import java.util.*

class StopSpellCheckable(magicPoints: Int) : MagicCheckable<StopSpellInvocation, StopSpellReception, StopSpellCheck>(
    magicPoints
), MagicPointer {
    override fun check(
        invocation: StopSpellInvocation, reception: StopSpellReception,
    ): StopSpellCheck {
        return StopSpellCheck(
            invocation.magicPoints,
            magicPoints,
            invocation.stopSpellRequirement,
            reception.stopSpellResistance,
            System.currentTimeMillis(),
            UUID.randomUUID()
        )
    }
}