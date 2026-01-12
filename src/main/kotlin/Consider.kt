package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

abstract class Consider<T : AttributeReceiver, C : Consideration>(rules: List<Rule<T>>) : Ruler<T> {
    @Transient
    protected val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    override var rules: List<Rule<T>> = rules
        set(value) {
            field = value
            logger.trace("rules={} rules.size={}", field, field.size)
        }

    init {
        this.rules = rules
    }

    private fun checkEvaluation(evaluation: Evaluation, evaluationIndex: Int): Boolean {
        logger.debug("evaluation={} evaluationIndex={}", evaluation, evaluationIndex)
        return evaluation.result
    }

    private fun checkEvaluations(evaluations: List<Evaluation>): Boolean {
        logger.debug("evaluations.size={}", evaluations.size)
        return evaluations.withIndex().all { (evaluationIndex: Int, evaluation) ->
            return checkEvaluation(evaluation, evaluationIndex)
        }
    }

    private fun checkReceiver(assessment: Assessment, receiver: T, receiverIndex: Int): Boolean {
        logger.debug("assessment={} receiver={} receiverIndex={}", assessment, receiver, receiverIndex)
        return assessment.result
    }

    protected fun checkReceivers(
        receivers: List<T>, rules: List<Rule<T>>,
    ): Pair<List<Assessment>, List<T>> {
        logger.debug("receivers.size={} rules.size={}", receivers.size, rules.size)
        val assessments = mutableListOf<Assessment>()
        val receivers = receivers.filterIndexed { receiverIndex, receiver ->
            val evaluations = getEvaluations(receiver, receiverIndex, rules)
            val assessment = getAssessment(evaluations, receiver, receiverIndex)
            assessments.add(assessment)
            checkReceiver(assessment, receiver, receiverIndex)
        }
        val pair: Pair<List<Assessment>, List<T>> = Pair(assessments, receivers)
        return pair
    }

    fun consider(receivers: List<T>): Pair<List<T>, C> {
        logger.debug("receivers.size={}", receivers.size)
        val (assessments, receivers) = checkReceivers(receivers, rules)
        return getPair(assessments, receivers)
    }

    private fun getAssessment(
        evaluations: List<Evaluation>,
        receiver: T,
        receiverIndex: Int,
    ): Assessment {
        logger.debug(
            "evaluations.size={} receiver={} receiverIndex={}", evaluations.size, receiver, receiverIndex
        )
        return Assessment(
            evaluations,
            receiver.uuid,
            checkEvaluations(evaluations),
            System.currentTimeMillis(),
            UUID.randomUUID(),
        )
    }

    protected abstract fun getConsideration(assessments: List<Assessment>, receivers: List<T>): C

    private fun getEvaluation(receiver: T, receiverIndex: Int, rule: Rule<T>, ruleIndex: Int): Evaluation {
        logger.debug("receiver={} receiverIndex={} rule={} ruleIndex={}", receiver, receiverIndex, rule, ruleIndex)
        return rule.evaluate(receiver)
    }

    private fun getEvaluations(receiver: T, receiverIndex: Int, rules: List<Rule<T>>): List<Evaluation> {
        logger.debug("receiver={} receiverIndex={} rules.size={}", receiver, receiverIndex, rules.size)
        return rules.mapIndexed { ruleIndex, rule ->
            getEvaluation(receiver, receiverIndex, rule, ruleIndex)
        }
    }

    private fun getPair(assessments: List<Assessment>, receivers: List<T>): Pair<List<T>, C> {
        logger.debug("assessments.size={} receivers.size={}", assessments.size, receivers.size)
        return Pair(receivers, getConsideration(assessments, receivers))
    }
}