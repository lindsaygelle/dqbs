package com.github.lindsaygelle

class Sleep(limit: Int, magicPoints: Int) :
    MagicAbility<SleepInvoker, SleepReceiver, SleepInvocation, SleepReception, SleepCheck>(limit, magicPoints) {
    override fun applyEffect(
        invocation: SleepInvocation, invoker: SleepInvoker, receiver: SleepReceiver, reception: SleepReception
    ) {
        receiver.statusSleep = true
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