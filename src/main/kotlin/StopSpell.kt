package com.github.lindsaygelle

import java.util.*

class StopSpell(
    limit: Int,
    magicPoints: Int,
) : MagicAbility<StopSpellInvoker, StopSpellReceiver, StopSpellInvocation, StopSpellReception, StopSpellCheck, StopSpellEffect>(
    limit, magicPoints
) {
    override fun getEffect(
        check: StopSpellCheck,
        invocation: StopSpellInvocation,
        invoker: StopSpellInvoker,
        receiver: StopSpellReceiver,
        reception: StopSpellReception,
    ): StopSpellEffect {
        receiver.statusStopSpell = check.result
        if (receiver.statusStopSpell) {
            receiver.turnsStopSpell = 0
        }
        return StopSpellEffect(receiver.statusStopSpell, System.currentTimeMillis(), UUID.randomUUID())
    }

    override fun getCheckable(): Checkable<StopSpellInvocation, StopSpellReception, StopSpellCheck> {
        return StopSpellCheckable(magicPoints)
    }

    override fun getInvocable(): Invocable<StopSpellInvoker, StopSpellInvocation> {
        return StopSpellInvocable(magicPoints)
    }

    override fun getReceivable(): Receivable<StopSpellReceiver, StopSpellReception> {
        return StopSpellReceivable()
    }
}