package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.UUID

abstract class Aspect<K, V : Comparable<V>, R: AspectContext<K, V>>(
    aspect: K,
    operator: Operator,
    uuid: UUID,
    value: V,
) : Identifier {
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    var aspect: K = aspect
        set(value) {
            field = value
            logger.trace("aspect={} hashCode={}", field, hashCode())
        }

    var operator: Operator = operator
        set(value) {
            field = value
            logger.trace("operator={} hashCode={}", field, hashCode())
        }

    override var uuid: UUID = uuid
        set(value) {
            field = value
            logger.trace("uuid={} hashCode={}", field, hashCode())
        }

    var value: V = value
        set(value) {
            field = value
            logger.trace("value={} hashCode={}", field, hashCode())
        }

    init {
        this.aspect = aspect
        this.operator = operator
        this.uuid = uuid
        this.value = value
    }

    fun check(aspectAsker: AspectAsker, aspectProvider: AspectProvider<K, V>): Pair<Boolean, R> {
        val aspectValue = aspectProvider.provideAspect(aspect, aspectAsker)
        val result = checkValue(aspectValue)
        val aspectContext: R = getContext(aspectAsker, aspectProvider, aspectValue)
        val pair: Pair<Boolean, R> = Pair(result, aspectContext)
        return pair
    }

    protected fun checkValue(aspectValue: V): Boolean {
        return when (operator) {
            Operator.EQUAL_TO -> value == aspectValue
            Operator.GREATER_THAN -> value > aspectValue
            Operator.GREATER_THAN_EQUAL_TO -> value >= aspectValue
            Operator.LESS_THAN -> value < aspectValue
            Operator.LESS_THAN_EQUAL_TO -> value <= aspectValue
            Operator.NOT_EQUAL_TO -> value != aspectValue
        }
    }

    protected abstract fun getContext(aspectAsker: AspectAsker, aspectProvider: AspectProvider<K, V>, aspectValue: V): R
}