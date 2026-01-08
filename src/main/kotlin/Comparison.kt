package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class Comparison(
    attribute: Attribute,
    attributeValue: Int,
    operator: Operator,
    result: Boolean,
    timeMilliseconds: Long,
    value: Int,
    uuid: UUID,
) {
    var attribute: Attribute = attribute
        set(value) {
            field = value
            logger.trace("attribute={}", field)
        }

    var attributeValue: Int = attributeValue
        set(value) {
            field = value
            logger.trace("attributeValue={}", field)
        }

    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    var operator: Operator = operator
        set(value) {
            field = value
            logger.trace("operator={}", field)
        }

    var result: Boolean = result
        set(value) {
            field = value
            logger.trace("result={}", field)
        }

    var timeMilliseconds: Long = timeMilliseconds
        set(value) {
            field = value
            logger.trace("timeMilliseconds={}", field)
        }

    var uuid: UUID = uuid
        set(value) {
            field = value
            logger.trace("uuid={}", field)
        }

    var value: Int = value
        set(value) {
            field = value
            logger.trace("value={}", field)
        }

    init {
        this.attribute = attribute
        this.attributeValue = attributeValue
        this.operator = operator
        this.result = result
        this.timeMilliseconds = timeMilliseconds
        this.uuid = uuid
        this.value = value
    }

    override fun toString(): String {
        return "{attribute=${attribute} attributeValue=${attributeValue} hashCode=${hashCode()} operator=${operator} result=${result} timeMilliseconds=${timeMilliseconds} uuid=${uuid} value=${value}}"
    }
}