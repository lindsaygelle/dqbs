package com.github.lindsaygelle

open class MagicContext(magicPoints: Int) : AbilityContext(),
    MagicPointer {
    override var magicPoints: Int = magicPoints
}
