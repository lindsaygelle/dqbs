package com.github.lindsaygelle


import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ComparisonContext(
    attribute: Attribute,
    attributeValue: Int,
    operator: Operator,
    priority: Int,
    result: Boolean,
    timeMilliseconds: Long,
    value: Int,
) {
    var attribute: Attribute = attribute
        set(value) {
            field = value
            logger.trace("attribute={} hashCode={}", field, hashCode())
        }

    var attributeValue: Int = attributeValue
        set(value) {
            field = value
            logger.trace("attributeValue={} hashCode={}", field, hashCode())
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

    var result: Boolean = result
        set(value) {
            field = value
            logger.trace("result={} hashCode={}", field, hashCode())
        }

    var timeMilliseconds: Long = timeMilliseconds
        set(value) {
            field = value
            logger.trace("timeMilliseconds={} hashCode={}", field, hashCode())
        }

    var value: Int = value
        set(value) {
            field = value
            logger.trace("value={} hashCode={}", field, hashCode())
        }

    init {
        this.attribute = attribute
        this.attributeValue = attributeValue
        this.operator = operator
        this.priority = priority
        this.result = result
        this.timeMilliseconds = timeMilliseconds
        this.value = value
    }

    override fun toString(): String {
        return "{attribute=${attribute} attributeValue=${attributeValue} operator=${operator} priority=${priority} result=${result} timeMilliseconds=${timeMilliseconds} value=${value} hashCode=${hashCode()}}"
    }
}
