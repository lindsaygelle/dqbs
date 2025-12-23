package com.github.lindsaygelle

/*
class Heal(override var magicPoints: Int) : MagicAbility<HealInvoker, HealReceiver, HealContext>() {
    private fun getInvokerContext(invoker: HealInvoker): HealInvokerContext {
        return HealInvokerContext(
            (invoker.magicPoints - magicPoints) >= 0, System.currentTimeMillis()
        )
    }

    private fun getReceiverContext(receiver: HealReceiver): HealReceiverContext {
        return HealReceiverContext(
            receiver.hitPoints < receiver.hitPointsMaximum, System.currentTimeMillis()
        )
    }

    private fun getContext(
        healInvokable: HealInvokable,
        healReceivable: HealReceivable,
        invokerContext: HealInvokerContext,
        receiverContext: HealReceiverContext,
    ): HealContext {
        return HealContext(
            healInvokable, healReceivable, invokerContext, magicPoints, receiverContext, false, timeMilliseconds
        )
    }

    private fun getInvokable(invoker: HealInvoker): HealInvokable {
        val timeMilliseconds = System.currentTimeMillis()
        val healScale = invoker.healScale
        val healShift = invoker.healShift
        val healRangeRandom = invoker.healRangeRandom
        val healRangeValue = healRangeRandom and healShift
        val healValue = healRangeValue + healScale
        return HealInvokable(
            healRangeRandom, healRangeValue, healValue, timeMilliseconds
        )
    }

    private fun getReceivable(receiver: HealReceiver): HealReceivable {
        val timeMilliseconds = System.currentTimeMillis()
        val hitPoints = receiver.hitPoints
        val hitPointsMaximum = receiver.hitPointsMaximum
        return HealReceivable(
            hitPoints, hitPointsMaximum, timeMilliseconds
        )
    }

    override fun use(invoker: HealInvoker, receiver: HealReceiver): HealContext {
        val invokable = getInvokable(invoker)
        val invokerContext = getInvokerContext(invoker)
        val receivable = getReceivable(receiver)
        val receiverContext = getReceiverContext(receiver)
        if (invokerContext.magicPointsCheck && receiverContext.hitPointsCheck) {
            receiver.hitPoints = invokable.healValue
        }
        val context = getContext(invokable, receivable, invokerContext, receiverContext)
        return context
    }
}*/