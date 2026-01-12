package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class Appraise(rules: List<Rule>) {
    @Transient
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    var rules = rules
        set(value) {
            field = value
            logger.trace("rules={} rules.size={}", field, field.size)
        }

    init {
        this.rules = rules
    }

    fun check(receivers: List<ActionReceiver>): Pair<List<ActionReceiver>, Appraisal> {
        logger.debug("receivers.size={}", receivers.size)
        val (assessments, receivers) = checkReceivers(receivers, rules)
        val appraisal = getAppraisal(assessments, receivers)
        val pair: Pair<List<ActionReceiver>, Appraisal> = Pair(receivers, appraisal)
        return pair
    }

    private fun checkReceiver(assessment: Assessment, receiver: ActionReceiver, receiverIndex: Int): Boolean {
        logger.debug("assessment={} receiver={} receiverIndex={}", assessment, receiver, receiverIndex)
        return assessment.result
    }

    private fun checkReceivers(
        receivers: List<ActionReceiver>, rules: List<Rule>
    ): Pair<List<Assessment>, List<ActionReceiver>> {
        logger.debug("receivers.size={} rules.size={}", receivers.size, rules.size)
        val assessments = mutableListOf<Assessment>()
        val receivers = receivers.filterIndexed { receiverIndex, receiver ->
            val evaluations = getEvaluations(receiver, receiverIndex, rules)
            val assessment = getAssessment(evaluations, receiver, receiverIndex)
            assessments.add(assessment)
            checkReceiver(assessment, receiver, receiverIndex)
        }
        val pair: Pair<List<Assessment>, List<ActionReceiver>> = Pair(assessments, receivers)
        return pair
    }

    private fun getAppraisal(assessments: List<Assessment>, receivers: List<ActionReceiver>): Appraisal {
        logger.debug("assessments.size={} receivers.size={}", assessments.size, receivers.size)
        val result = receivers.isNotEmpty()
        return Appraisal(assessments, result, System.currentTimeMillis(), UUID.randomUUID())
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

    private fun getAssessment(
        evaluations: List<Evaluation>,
        receiver: ActionReceiver,
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

    private fun getEvaluation(receiver: ActionReceiver, receiverIndex: Int, rule: Rule, ruleIndex: Int): Evaluation {
        logger.debug("receiver={} receiverIndex={} rule={} ruleIndex={}", receiver, receiverIndex, rule, ruleIndex)
        return rule.evaluate(receiver)
    }

    private fun getEvaluations(receiver: ActionReceiver, receiverIndex: Int, rules: List<Rule>): List<Evaluation> {
        logger.debug("receiver={} receiverIndex={} rules.size={}", receiver, receiverIndex, rules.size)
        return rules.mapIndexed { ruleIndex, rule ->
            getEvaluation(receiver, receiverIndex, rule, ruleIndex)
        }
    }
}