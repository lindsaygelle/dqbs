package com.github.lindsaygelle

import java.util.UUID

class AttributeCheckResult(
    val attribute: Attribute,
    val attributeAskerUUID: UUID,
    val attributeAskerValue: Int,
    val attributeCheckUUID: UUID,
    val attributeProviderUUID: UUID,
    val attributeProviderValue: Int,
    val checkValue: Boolean,
    val operatorType: OperatorType,
    val priorityType: PriorityType,
    val timeMillisecondsBegin: Long,
    val timeMillisecondsEnd: Long,
)