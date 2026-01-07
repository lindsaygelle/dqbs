package com.github.lindsaygelle

class Sleep(limit: Int, magicPoints: Int) :
    MagicAbility<SleepInvoker, SleepReceiver, SleepInvocation, SleepReception, SleepCheck, Effect>(limit, magicPoints) {
    override fun getEffect(
        check: SleepCheck,
        invocation: SleepInvocation,
        invoker: SleepInvoker,
        receiver: SleepReceiver,
        reception: SleepReception
    ): Effect {
        if (check.result) {
            receiver.statusSleep = true
        }
        return Effect()
    }

    override fun getCheckable(): Checkable<SleepInvocation, SleepReception, SleepCheck> {
        return SleepCheckable(magicPoints)
    }

    override fun getInvocable(): Invocable<SleepInvoker, SleepInvocation> {
        return SleepInvocable(magicPoints)
    }

    override fun getReceivable(): Receivable<SleepReceiver, SleepReception> {
        return SleepReceivable()
    }
}