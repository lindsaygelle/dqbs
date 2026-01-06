package com.github.lindsaygelle

import java.util.*

class SleepResolvable : Resolvable<SleepResolver, SleepResolution>() {
    override fun resolve(resolver: SleepResolver): SleepResolution {
        val sleepResolutionRandom = resolver.sleepResolutionRange.random()
        val turnsSleep = resolver.turnsSleep
        val resolved = sleepResolutionRandom == resolver.sleepResolutionMaximum
        if (resolved) {
            resolver.statusSleep = false
            resolver.turnsSleep = 0
        }
        return SleepResolution(
            resolved = resolved,
            sleepResolutionRandom = sleepResolutionRandom,
            timeMilliseconds = System.currentTimeMillis(),
            turnsSleep = turnsSleep,
            uuid = UUID.randomUUID(),
        )
    }
}
