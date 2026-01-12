package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class Rank<T : AttributeReceiver>(override var rules: List<Rule<T>>) : Ruler<T> {
    @Transient
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    private fun checkReceiver(receiver: T, receiverIndex: Int, score: Score): Int {
        logger.debug("receiver={} receiverIndex={} score={}", receiver, receiverIndex, score)
        return score.value
    }

    private fun checkReceivers(
        receivers: List<T>, rules: List<Rule<T>>,
    ): Pair<List<Score>, List<T>> {
        logger.debug("receivers.size={} rules.size={}", receivers.size, rules.size)
        val scores = mutableListOf<Score>()
        val receivers = receivers.withIndex().sortedByDescending { (receiverIndex, receiver) ->
            val evaluations = getEvaluations(receiver, receiverIndex, rules)
            val score = getScore(evaluations, receiver, receiverIndex)
            scores.add(score)
            checkReceiver(receiver, receiverIndex, score)
        }
        val pair: Pair<List<Score>, List<T>> = Pair(scores, receivers.map { it.value })
        return pair
    }

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

    private fun getPair(receivers: List<T>, scores: List<Score>): Pair<List<T>, Ranking> {
        logger.debug("receivers.size={} scores.size={}", receivers.size, scores.size)
        return Pair(receivers, getRanking(scores))
    }

    private fun getRanking(scores: List<Score>): Ranking {
        logger.debug("scores.size={}", scores.size)
        return Ranking(scores, System.currentTimeMillis(), UUID.randomUUID())
    }

    private fun getScore(
        evaluations: List<Evaluation>,
        receiver: T,
        receiverIndex: Int,
    ): Score {
        logger.debug(
            "evaluations.size={} receiver={} receiverIndex={}", evaluations.size, receiver, receiverIndex
        )
        return Score(
            evaluations,
            receiver.uuid,
            System.currentTimeMillis(),
            UUID.randomUUID(),
            evaluations.sumOf { evaluation -> if (evaluation.result) 1 else 0 })
    }

    fun order(receivers: List<T>): Pair<List<T>, Ranking> {
        logger.debug("receivers.size={}", receivers.size)
        val (scores, receivers) = checkReceivers(receivers, rules)
        return getPair(receivers, scores)
    }
}