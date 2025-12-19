package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Comparison(attribute: Attribute, operator: Operator, value: Int) {
    private var attribute: Attribute = attribute
        set(value) {
            field = value
            logger.trace("attribute={}", field)
        }
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

    fun compare(battler: Battler) {
        val attributeValue = when (attribute) {
            Attribute.AGILITY -> battler.hitPoints
            Attribute.HIT_POINTS -> battler.hitPoints
            Attribute.HIT_POINTS_PERCENTAGE -> battler.hitPointsPercentage
            Attribute.HIT_POINTS_MAXIMUM -> battler.hitPointsMaximum
            Attribute.MAGIC_POINTS -> battler.magicPoints
            Attribute.MAGIC_POINTS_MAXIMUM -> battler.magicPointsMaximum
            Attribute.MAGIC_POINTS_PERCENTAGE -> battler.magicPointsPercentage
            Attribute.STRENGTH -> battler.strength
        }
        compareValue(attributeValue)
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
}