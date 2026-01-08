package com.github.lindsaygelle

import java.util.*

class Sleep(
    limit: Int,
    magicPoints: Int,
) : MagicAbility<SleepInvoker, SleepReceiver, SleepInvocation, SleepReception, SleepCheck, SleepEffect>(
    limit, magicPoints
) {
    override fun getEffect(
        check: SleepCheck,
        invocation: SleepInvocation,
        invoker: SleepInvoker,
        receiver: SleepReceiver,
        reception: SleepReception,
    ): SleepEffect {
        receiver.statusSleep = check.result
        if (receiver.statusSleep) {
            receiver.turnsSleep = 0
        }
        return SleepEffect(receiver.statusSleep, System.currentTimeMillis(), UUID.randomUUID())
    }

    override fun getCheckable(): Checkable<SleepInvocation, SleepReception, SleepCheck> {
        return SleepCheckable(magicPoints)
    }

    override fun getInvocable(): Invocable<SleepInvoker, SleepInvocation> {
        return SleepInvocable()
    }

    override fun getReceivable(): Receivable<SleepReceiver, SleepReception> {
        return SleepReceivable()
    }
}