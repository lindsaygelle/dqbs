package com.github.lindsaygelle

open class ActionAssess {
    fun process(actionInvoker: ActionInvoker, actionReceivers: Collection<IndexedValue<ActionReceiver>>) : ActionAssessContext {
        val timeMilliseconds = System.currentTimeMillis()
        return ActionAssessContext(result = listOf(true, false).random() // TODO
            , timeMilliseconds = timeMilliseconds)
    }
}
