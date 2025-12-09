package com.github.lindsaygelle

import java.util.UUID

class AttributeAspect(
    aspect: Attribute,
    operator: Operator,
    uuid: UUID,
    value: Int,
) : Aspect<Attribute, Int, AttributeAspectContext>(
    aspect = aspect, operator = operator, uuid = uuid, value = value
) {
    override fun getContext(
        aspectAsker: AspectAsker,
        aspectProvider: AspectProvider<Attribute, Int>,
        aspectValue: Int,
    ): AttributeAspectContext {
        return AttributeAspectContext(
            aspect = aspect, aspectValue = aspectValue, value = value
        )
    }
}