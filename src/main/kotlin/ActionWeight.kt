package com.github.lindsaygelle

open class ActionWeight {
    fun process(actionReceivers: List<IndexedValue<ActionReceiver>>): ActionWeightContext {
        return ActionWeightContext()
    }
}
