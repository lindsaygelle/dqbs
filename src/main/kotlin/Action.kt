package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Action(
    ability: Ability<AbilityInvoker, ActionReceiver, Invocation, Reception, Check, Effect>,
    appraise: Appraise,
    // decide: Decide,
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

    @Transient
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    init {
        this.ability = ability
        this.appraise = appraise
    }

    fun use(invoker: AbilityInvoker, receivers: List<ActionReceiver>): Activity {
        val (_, appraisal) = appraise.check(receivers)
        if (appraisal.result) {

        }
        return Activity(appraisal)
    }

    override fun toString(): String {
        return "{ability=${ability} appraise=${appraise} hashCode=${hashCode()}}"
    }
}