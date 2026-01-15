package com.github.lindsaygelle.dqbs

import java.util.*

class Comparison<R : Actor>(
    override var attribute: Attribute,
    override var operation: Operation,
    var value: Int,
    override var uuid: UUID,
) : Attributer,
    Checker<R>,
    Operator,
    UniversalIdentifier {
    override fun check(
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        tracers.add(
            ComparisonBegin(
                attribute,
                uuid,
                operation,
                receiver.uuid,
                System.currentTimeMillis(),
                UUID.randomUUID(),
                value,
            )
        )
        val receiverValue = getReceiverValue(receiver)
        val result = getResult(receiverValue)
        tracers.add(
            ComparisonEnd(
                attribute,
                uuid,
                operation,
                receiver.uuid,
                receiverValue,
                result,
                System.currentTimeMillis(),
                UUID.randomUUID(),
                value
            )
        )
        return result
    }

    private fun getReceiverValue(receiver: R): Int {
        return when (attribute) {
            Attribute.AGILITY -> receiver.agility
            Attribute.STRENGTH -> receiver.strength
        }
    }

    private fun getResult(receiverValue: Int): Boolean {
        return when (operation) {
            Operation.EQUAL_TO -> value == receiverValue
            Operation.GREATER_THAN -> value > receiverValue
            Operation.GREATER_THAN_EQUAL_TO -> value >= receiverValue
            Operation.LESS_THAN -> value < receiverValue
            Operation.LESS_THAN_EQUAL_TO -> value <= receiverValue
            Operation.NOT_EQUAL_TO -> value != receiverValue
        }
    }
}