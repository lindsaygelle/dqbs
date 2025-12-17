package com.github.lindsaygelle

class StopSpell(magicPoints: Int) : MagicAbility<StopSpellInvoker, StopSpellReceiver, StopSpellContext>(magicPoints) {
    override fun use(
        invoker: StopSpellInvoker,
        receiver: StopSpellReceiver,
    ): StopSpellContext {
        TODO("Not yet implemented")
    }
}
