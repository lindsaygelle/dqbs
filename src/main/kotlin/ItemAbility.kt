package com.github.lindsaygelle

abstract class ItemAbility<A : ItemInvoker, B : AbilityReceiver, C : ItemContext>(item: Item) : Ability<A, B, C>(),
    Itemizer {
    var item: Item = item
        set(value) {
            field = value
            logger.trace("item={}", field)
        }
    init {
        this.item = item
    }
}
