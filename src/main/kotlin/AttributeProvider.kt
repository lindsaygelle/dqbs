package com.github.lindsaygelle

interface AttributeProvider : Identifier {
    fun getAttribute(attribute: Attribute, attributeAsker: AttributeAsker): Int
}
