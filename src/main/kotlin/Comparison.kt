package com.github.lindsaygelle.dqbs

import java.util.*

class Comparison<R : Actor>(
    private val attribute: Attribute,
    private val operation: Operation,
    private val value: Int,
) : Checker<R> {
    private val uuid: UUID = UUID.randomUUID()

    init {
        require(value > -1)
    }

    override fun check(
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        tracers.add(
            ComparisonBegin(
                attribute,
                operation,
                receiver.uuid,
                System.currentTimeMillis(),
                uuid,
                value,
            )
        )
        val receiverValue = getReceiverValue(receiver)
        val result = getResult(receiverValue)
        tracers.add(
            ComparisonEnd(
                attribute, operation, receiver.uuid, receiverValue, result, System.currentTimeMillis(), uuid, value
            )
        )
        return result
    }

    private fun getReceiverValue(receiver: R): Int {
        return when (attribute) {
            Attribute.AGILITY -> receiver.agility
            Attribute.STRENGTH -> receiver.strength
            Attribute.MAGIC_POINTS -> receiver.magicPoints
            Attribute.SLEEP_REQUIREMENT_MAXIMUM -> receiver.sleepRequirementMaximum
            Attribute.SLEEP_REQUIREMENT_MINIMUM -> receiver.sleepRequirementMinimum
            Attribute.SLEEP_RESISTANCE_MAXIMUM -> receiver.sleepRequirementMaximum
            Attribute.SLEEP_RESISTANCE_MINIMUM -> receiver.sleepRequirementMinimum
            Attribute.STOP_SPELL_REQUIREMENT_MAXIMUM -> receiver.stopSpellRequirementMaximum
            Attribute.STOP_SPELL_REQUIREMENT_MINIMUM -> receiver.stopSpellRequirementMaximum
            Attribute.STOP_SPELL_RESISTANCE_MAXIMUM -> receiver.stopSpellResistanceMaximum
            Attribute.STOP_SPELL_RESISTANCE_MINIMUM -> receiver.sleepResistanceMaximum
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