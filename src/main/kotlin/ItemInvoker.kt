package com.github.lindsaygelle

interface ItemInvoker : AbilityInvoker {
    var items: MutableMap<Item, Int>
}