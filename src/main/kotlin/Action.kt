package com.github.lindsaygelle

class Action {
    // var ability: Ability<Battler, Battler>
    lateinit var assessment: Assessment
    lateinit var choice: Choice
    lateinit var weight: Weight
}/*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

open class Action(actionAssess: ActionAssess, actionChoice: ActionChoice, actionWeight: ActionWeight, priority: Int) :
    Prioritizer {
    private var actionAssess: ActionAssess = actionAssess
        set(value) {
            field = value
            logger.debug("actionAssess={}", field)
        }
    private var actionChoice: ActionChoice = actionChoice
        set(value) {
            field = value
            logger.debug("actionTarget={}", field)
        }
    private var actionWeight: ActionWeight = actionWeight
        set(value) {
            field = value
            logger.debug("actionWeight={}", field)
        }
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    override var priority: Int = 0
        set(value) {
            field = maxOf(0, value)
            logger.debug("priority={}", field)
        }

    init {
        this.actionAssess = actionAssess
        this.actionChoice = actionChoice
        this.actionWeight = actionWeight
        this.priority = priority
    }

    fun process(
        actionInvoker: ActionInvoker,
        actionReceivers: List<IndexedValue<ActionReceiver>>
    ): ActionContext {
        val timeMilliseconds = System.currentTimeMillis()
        val actionConditionContext = processActionAssess(actionInvoker, actionReceivers)
        var actionChoiceContext: ActionChoiceContext? = null
        var actionWeightContext: ActionWeightContext? = null
        if (actionConditionContext.result) {
            actionChoiceContext = processActionChoice(actionInvoker, actionReceivers)
            if (actionChoiceContext.result) {
                // processActionWeight()
            }
        }
        return ActionContext(
            actionAssessContext = actionConditionContext,
            actionChoiceContext = actionChoiceContext,
            actionWeightContext = actionWeightContext,
            result = actionConditionContext.result && actionChoiceContext?.result == true,
            timeMilliseconds = timeMilliseconds // TODO
        )
    }

    private fun processActionAssess(
        actionInvoker: ActionInvoker,
        actionReceivers: List<IndexedValue<ActionReceiver>>
    ): ActionAssessContext {
        logger.debug(
            "actionCondition={} actionInvoker={} actionReceivers.size={}",
            actionAssess,
            actionInvoker,
            actionReceivers.size
        )
        return actionAssess.process(actionInvoker, actionReceivers)
    }

    private fun processActionChoice(
        actionInvoker: ActionInvoker,
        actionReceivers: List<IndexedValue<ActionReceiver>>
    ): ActionChoiceContext {
        logger.debug(
            "actionInvoker={} actionReceivers.size={} actionTarget={}",
            actionInvoker,
            actionReceivers.size,
            actionChoice
        )
        return actionChoice.process(actionInvoker, actionReceivers)
    }

    private fun processActionWeight(actionReceivers: List<IndexedValue<ActionReceiver>>) : ActionWeightContext {
        return actionWeight.process(actionReceivers)
    }
}
*/
