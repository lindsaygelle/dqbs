package com.github.lindsaygelle

import java.util.UUID

class AttributeCheck(
    val attribute: Attribute,
    val operatorType: OperatorType,
    val priorityType: PriorityType,
    val value: Int,
) : Identifier {
    override val uuid: UUID = UUID.randomUUID()
    fun check(attributeAsker: AttributeAsker, attributeProvider: AttributeProvider): AttributeCheckResult {
        val timeMillisecondsBegin = System.currentTimeMillis()
        val attributeProviderValue = attributeProvider.getAttribute(attribute, attributeAsker)
        val checkValue = checkAttribute(attributeProviderValue)
        val timeMillisecondsEnd = System.currentTimeMillis()
        val attributeCheckResult = AttributeCheckResult(
            attribute = attribute,
            attributeAskerUUID = attributeAsker.uuid,
            attributeAskerValue = value,
            attributeCheckUUID = uuid,
            attributeProviderUUID = attributeProvider.uuid,
            attributeProviderValue = attributeProviderValue,
            checkValue = checkValue,
            operatorType = operatorType,
            priorityType = priorityType,
            timeMillisecondsBegin = timeMillisecondsBegin,
            timeMillisecondsEnd = timeMillisecondsEnd,
        )
        return attributeCheckResult
    }

    fun checkAttribute(attributeValue: Int): Boolean {
        return when (operatorType) {
            OperatorType.EQUAL_TO -> attributeValue == value
            OperatorType.GREATER_THAN -> attributeValue > value
            OperatorType.GREATER_THAN_EQUAL_TO -> attributeValue >= value
            OperatorType.LESS_THAN -> attributeValue < value
            OperatorType.LESS_THAN_EQUAL_TO -> attributeValue <= value
            OperatorType.NOT_EQUAL -> attributeValue != value
        }
    }
}