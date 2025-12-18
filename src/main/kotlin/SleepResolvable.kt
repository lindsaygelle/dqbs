package com.github.lindsaygelle

class SleepResolvable : Resolvable<SleepResolver> {
    override fun resolve(resolver: SleepResolver): Resolution {
        return SleepResolution()
    }
}
