package com.github.lindsaygelle

class HealContext(
    var healInvokable: HealInvokable,
    var healReceivable: HealReceivable,
    invokerContext: HealInvokerContext,
    override var magicPoints: Int,
    receiverContext: HealReceiverContext,
    override var timeMilliseconds: Long,
) : MagicContext {
    override val invokerContext: Context = invokerContext
    override val receiverContext: Context = receiverContext
}