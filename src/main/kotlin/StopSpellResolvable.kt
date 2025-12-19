package com.github.lindsaygelle

class StopSpellResolvable: Resolvable<StopSpellResolver> {
    override fun resolve(resolver: StopSpellResolver): Resolution {
        return StopSpellResolution()
    }
}
