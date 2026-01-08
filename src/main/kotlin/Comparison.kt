package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Comparison(attribute: Attribute, operator: Operator, value: Int) {
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

    fun compare(actor: Actor) {
        val attributeValue = when (attribute) {
            Attribute.AGILITY -> actor.hitPoints
            Attribute.HIT_POINTS -> actor.hitPoints
            Attribute.HIT_POINTS_PERCENTAGE -> actor.hitPointsPercentage
            Attribute.HIT_POINTS_MAXIMUM -> actor.hitPointsMaximum
            Attribute.MAGIC_POINTS -> actor.magicPoints
            Attribute.MAGIC_POINTS_MAXIMUM -> actor.magicPointsMaximum
            Attribute.MAGIC_POINTS_PERCENTAGE -> actor.magicPointsPercentage
            Attribute.STRENGTH -> actor.strength
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

    override fun toString(): String {
        return "{attribute=${attribute} operator=${operator} value=${value} ${this.javaClass.superclass.simpleName}=${super.toString()}}"
    }
}