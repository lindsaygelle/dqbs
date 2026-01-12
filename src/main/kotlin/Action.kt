package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Action(
    ability: Ability<ActionInvoker, ActionReceiver, Invocation, Reception, Check, Effect>,
    appraise: Appraise<ActionReceiver>,
    decide: Decide<ActionReceiver>,
    rank: Rank<ActionReceiver>,
) {
    var ability: Ability<ActionInvoker, ActionReceiver, Invocation, Reception, Check, Effect> = ability
        set(value) {
            field = value
            logger.trace("ability={}", field)
        }

    var appraise: Appraise<ActionReceiver> = appraise
        set(value) {
            field = value
            logger.trace("appraise={}", field)
        }

    var decide: Decide<ActionReceiver> = decide
        set(value) {
            field = value
            logger.trace("decide={}", field)
        }

    @Transient
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    var rank: Rank<ActionReceiver> = rank
        set(value) {
            field = value
            logger.trace("rank={}", field)
        }

    init {
        this.ability = ability
        this.appraise = appraise
        this.decide = decide
        this.rank = rank
    }

    fun use(invoker: ActionInvoker, receivers: List<ActionReceiver>): Activity {
        // TODO
        val (_, appraisal) = appraise.consider(receivers)
        val (_, decision: Decision?) = if (appraisal.result) decide.consider(receivers) else Pair<List<ActionReceiver>, Decision?>(
            emptyList(), null
        )
        val (receivers, ranking: Ranking?) = if (decision?.result == true) rank.order(receivers) else Pair<List<ActionReceiver>, Ranking?>(
            emptyList(), null
        )
        var outcomes: List<Outcome<Check, Effect, Invocation, Reception>>? = null
        if (ranking != null) {
            outcomes = ability.use(invoker, receivers)
        }
        return Activity(appraisal, decision, outcomes, ranking)
    }

    override fun toString(): String {
        return "{ability=${ability} appraise=${appraise} decide=${decide} hashCode=${hashCode()}}"
    }
}