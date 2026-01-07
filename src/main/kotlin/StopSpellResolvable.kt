package com.github.lindsaygelle

import java.util.*

class StopSpellResolvable : Resolvable<StopSpellResolver, StopSpellResolution>() {
    override fun resolve(resolver: StopSpellResolver): StopSpellResolution {
        val stopSpellResolutionRandom = resolver.stopSpellResolutionRange.random()
        val turnsStopSpell = resolver.turnsStopSpell
        val resolved = stopSpellResolutionRandom == resolver.stopSpellResolutionMaximum
        if (resolved) {
            resolver.statusStopSpell = false
            resolver.turnsStopSpell = 0
        }
        return StopSpellResolution(
            resolved = resolved,
            stopSpellResolutionRandom = stopSpellResolutionRandom,
            timeMilliseconds = System.currentTimeMillis(),
            turnsStopSpell = turnsStopSpell,
            uuid = UUID.randomUUID(),
        )
    }
}