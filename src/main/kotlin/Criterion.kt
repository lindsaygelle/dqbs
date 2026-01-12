package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class Criterion<T : AttributeReceiver>(attribute: Attribute, operation: Operation, value: Int) : Attributer,
    Operator,
    Valuer {
    override var attribute: Attribute = attribute
        set(value) {
            field = value
            logger.trace("attribute={}", field)
        }

    @Transient
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    override var operation: Operation = operation
        set(value) {
            field = value
            logger.trace("operation={}", field)
        }

    override var value: Int = value
        set(value) {
            field = value
            logger.trace("value={}", field)
        }

    fun compare(receiver: T): Comparison {
        logger.debug("attribute={} operation={} receiver={} value={}", attribute, operation, receiver, value)
        val attributeValue = receiver.getAttribute(attribute)
        val result = compareValue(attributeValue, value)
        return Comparison(
            attribute, attributeValue, operation, result, System.currentTimeMillis(), value, UUID.randomUUID()
        )
    }

    private fun compareValue(attributeValue: Int, value: Int): Boolean {
        logger.debug("attributeValue={} value={}", attributeValue, value)
        return when (operation) {
            Operation.EQUAL_TO -> value == attributeValue
            Operation.GREATER_THAN -> value > attributeValue
            Operation.GREATER_THAN_EQUAL_TO -> value >= attributeValue
            Operation.LESS_THAN -> value < attributeValue
            Operation.LESS_THAN_EQUAL_TO -> value <= attributeValue
            Operation.NOT_EQUAL_TO -> value != attributeValue
        }
    }

    override fun toString(): String {
        return "{attribute=${attribute} hashCode=${hashCode()} operation=${operation} value=${value}}"
    }
}