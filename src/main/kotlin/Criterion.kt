package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class Criterion(attribute: Attribute, operator: Operator, value: Int) {
    private var attribute: Attribute = attribute
        set(value) {
            field = value
            logger.trace("attribute={}", field)
        }

    @Transient
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    private var operator: Operator = operator
        set(value) {
            field = value
            logger.trace("operator={}", field)
        }

    private var value: Int = value
        set(value) {
            field = value
            logger.trace("value={}", field)
        }

    fun compare(receiver: ActionReceiver): Comparison {
        val attributeValue = when (attribute) {
            Attribute.AGILITY -> receiver.hitPoints
            Attribute.HIT_POINTS -> receiver.hitPoints
            Attribute.HIT_POINTS_PERCENTAGE -> receiver.hitPointsPercentage
            Attribute.HIT_POINTS_MAXIMUM -> receiver.hitPointsMaximum
            Attribute.MAGIC_POINTS -> receiver.magicPoints
            Attribute.MAGIC_POINTS_MAXIMUM -> receiver.magicPointsMaximum
            Attribute.MAGIC_POINTS_PERCENTAGE -> receiver.magicPointsPercentage
            Attribute.STRENGTH -> receiver.strength
        }
        val result = compareValue(attributeValue)
        return Comparison(
            attribute, attributeValue, operator, result, System.currentTimeMillis(), value, UUID.randomUUID()
        )
    }

    private fun compareValue(attributeValue: Int): Boolean {
        return when (operator) {
            Operator.EQUAL_TO -> value == attributeValue
            Operator.GREATER_THAN -> value > attributeValue
            Operator.GREATER_THAN_EQUAL_TO -> value >= attributeValue
            Operator.LESS_THAN -> value < attributeValue
            Operator.LESS_THAN_EQUAL_TO -> value <= attributeValue
            Operator.NOT_EQUAL_TO -> value != attributeValue
        }
    }

    override fun toString(): String {
        return "{attribute=${attribute} hashCode=${hashCode()} operator=${operator} value=${value}}"
    }
}