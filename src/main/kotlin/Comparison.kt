package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class Comparison(
    attribute: Attribute,
    operator: Operator,
    priority: Int,
    uuid: UUID,
    value: Int,
) : Identifier {
    var attribute: Attribute = attribute
        set(value) {
            field = value
            logger.trace("attribute={} hashCode={}", field, hashCode())
        }

    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    var operator: Operator = operator
        set(value) {
            field = value
            logger.trace("operator={} hashCode={}", field, hashCode())
        }

    var priority: Int = priority
        set(value) {
            field = value
            logger.trace("priority={} hashCode={}", field, hashCode())
        }

    override var uuid: UUID = uuid
        set(value) {
            field = value
            logger.trace("uuid={} hashCode={}", field, hashCode())
        }

    var value: Int = value
        set(value) {
            field = value
            logger.trace("value={} hashCode={}", field, hashCode())
        }

    init {
        this.attribute = attribute
        this.operator = operator
        this.priority = priority
        this.uuid = uuid
        this.value = value
    }

    fun check(requester: Requester, provider: Provider): ComparisonContext {
        logger.debug("requester={} provider={} hashCode={}", requester, provider, hashCode())
        val timeMilliseconds = System.currentTimeMillis()
        val attributeValue = provider.provide(attribute, requester)
        val result = checkValue(attributeValue)
        val attributeContext = getComparisonContext(
            attributeValue = attributeValue,
            result = result,
            timeMilliseconds = timeMilliseconds
        )
        return attributeContext
    }

    private fun checkValue(attributeValue: Int): Boolean {
        logger.debug("attributeValue={} operator={} value={} hashCode={}", attributeValue, operator, value, hashCode())
        return when (operator) {
            Operator.EQUAL_TO -> value == attributeValue
            Operator.GREATER_THAN -> value > attributeValue
            Operator.GREATER_THAN_EQUAL_TO -> value >= attributeValue
            Operator.LESS_THAN -> value < attributeValue
            Operator.LESS_THAN_EQUAL_TO -> value <= attributeValue
            Operator.NOT_EQUAL_TO -> value != attributeValue
        }
    }

    private fun getComparisonContext(
        attributeValue: Int,
        result: Boolean,
        timeMilliseconds: Long,
    ): ComparisonContext {
        logger.debug(
            "attributeValue={} result={} timeMilliseconds={} hashCode={}",
            attributeValue,
            result,
            timeMilliseconds,
            hashCode()
        )
        return ComparisonContext(
            attribute = attribute,
            attributeValue = attributeValue,
            operator = operator,
            priority = priority,
            result = result,
            timeMilliseconds = timeMilliseconds,
            value = value,
        )
    }

    override fun toString(): String {
        return "{attribute=${attribute} operator=${operator} priority=${priority} uuid=${uuid} value=${value} hashCode=${hashCode()}"
    }
}
