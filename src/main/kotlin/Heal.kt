package com.github.lindsaygelle

class Heal<A: HealInvoker, B: HealReceiver>: MagicAbility<A, B>() {
    override fun use(abilityInvoker: A, abilityReceiver: B): AbilityContext {
        TODO("Not yet implemented")
    }
}