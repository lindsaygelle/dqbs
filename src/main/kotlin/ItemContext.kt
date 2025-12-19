package com.github.lindsaygelle

open class ItemContext(item: Item, name: String, timeMilliseconds: Long) : AbilityContext(name, timeMilliseconds) {
    var item: Item = item
        set(value) {
            field = value
            logger.trace("item={}", field)
        }

    init {
        this.item = item
    }
}