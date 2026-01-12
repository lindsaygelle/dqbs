package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Action(
    ability: Ability<AbilityInvoker, ActionReceiver, Invocation, Reception, Check, Effect>,
    appraise: Appraise,
    decide: Decide,
    weight: Weight,
) {
    var ability: Ability<AbilityInvoker, ActionReceiver, Invocation, Reception, Check, Effect> = ability
        set(value) {
            field = value
            logger.trace("ability={}", field)
        }

    var appraise: Appraise = appraise
        set(value) {
            field = value
            logger.trace("appraise={}", field)
        }

    var decide: Decide = decide
        set(value) {
            field = value
            logger.trace("decide={}", field)
        }

    @Transient
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    init {
        this.ability = ability
        this.appraise = appraise
        this.decide = decide
    }

    fun use(invoker: AbilityInvoker, receivers: List<ActionReceiver>): Activity {
        val (_, appraisal) = appraise.consider(receivers)
        val (receivers, decision: Decision?) = if (appraisal.result) decide.consider(receivers) else Pair<List<ActionReceiver>, Decision?>(
            emptyList(), null
        )
        if (decision?.result == true) {

        }
        return Activity(appraisal, decision)
    }

    override fun toString(): String {
        return "{ability=${ability} appraise=${appraise} decide=${decide} hashCode=${hashCode()}}"
    }
}