package com.github.lindsaygelle

class StopSpellResolvable(resolver: StopSpellResolver) : Resolvable<StopSpellResolver, StopSpellResolution>(resolver) {
    override fun resolve(): StopSpellResolution {
        val stopSpellResolutionRandom = resolver.stopSpellResolutionRandom
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
        )
    }
}