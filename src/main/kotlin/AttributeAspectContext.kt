package com.github.lindsaygelle

class AttributeAspectContext(
    override var aspect: Attribute,
    override var aspectValue: Int,
    override var value: Int
) : AspectContext<Attribute, Int> {}