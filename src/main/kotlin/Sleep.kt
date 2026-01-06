package com.github.lindsaygelle

import java.util.*

class Sleep(limit: Int, magicPoints: Int) : MagicAbility<SleepInvoker, SleepReceiver>(limit, magicPoints) {
    override fun getOutcome(invoker: SleepInvoker, receiver: SleepReceiver, receiverIndex: Int): Outcome {
        // TODO
        val invocation = SleepInvocable(magicPoints).invoke(invoker)
        val reception = SleepReceivable().receive(receiver)
        val check = SleepCheckable(magicPoints).check(invocation, reception)
        return Outcome(check, invocation, reception, System.currentTimeMillis(), UUID.randomUUID())
    }
}