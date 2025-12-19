package com.github.lindsaygelle

class SleepResolvable(resolver: SleepResolver) : Resolvable<SleepResolver, SleepResolution>(resolver) {
    override fun resolve(): SleepResolution {
        val sleepResolutionRandom = resolver.sleepResolutionRandom
        val resolved = sleepResolutionRandom == resolver.sleepResolutionMaximum
        if (resolved) {
            resolver.statusSleep = false
            resolver.turnsSleep = 0
        }
        return SleepResolution(resolved, sleepResolutionRandom, System.currentTimeMillis())
    }
}