package com.github.lindsaygelle

open class ActionChoice {
    fun process(
        actionInvoker: ActionInvoker,
        actionReceivers: Collection<IndexedValue<ActionReceiver>>
    ): ActionChoiceContext {
        return ActionChoiceContext(
            result = listOf(true, false).random() // TODO
        )
    }
}
