package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class Rule(
    criteria: List<Criterion>,
    match: Match,
) : Matcher {
    var criteria: List<Criterion> = criteria
        set(value) {
            field = value
            logger.trace("criteria={} criteria.size={}", field, field.size)
        }

    @Transient
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    override var match: Match = match
        set(value) {
            field = value
            logger.trace("match={}", field)
        }

    init {
        this.criteria = criteria
        this.match = match
    }

    private fun checkComparison(comparison: Comparison, comparisonIndex: Int): Boolean {
        logger.debug("comparison={} comparisonIndex={}", comparison, comparisonIndex)
        return comparison.result
    }

    private fun checkComparisons(comparisons: Iterable<IndexedValue<Comparison>>): Boolean {
        return when (match) {
            Match.ALL -> compareAll(comparisons)
            Match.ANY -> compareAny(comparisons)
        }
    }

    private fun compare(aggregator: (predicate: (IndexedValue<Comparison>) -> Boolean) -> Boolean): Boolean {
        logger.debug("aggregator={}", aggregator)
        return aggregator { (comparisonIndex, comparison) -> checkComparison(comparison, comparisonIndex) }
    }

    private fun compareAll(comparisons: Iterable<IndexedValue<Comparison>>): Boolean {
        return compare(comparisons::all)
    }

    private fun compareAny(comparisons: Iterable<IndexedValue<Comparison>>): Boolean {
        return compare(comparisons::any)
    }

    fun evaluate(receiver: ActionReceiver): Evaluation {
        logger.debug("receiver={}", receiver)
        val comparisons = getComparisons(criteria, receiver)
        val result = checkComparisons(comparisons.withIndex())
        return Evaluation(comparisons, match, result, System.currentTimeMillis(), UUID.randomUUID())
    }

    private fun getComparison(criterion: Criterion, criterionIndex: Int, receiver: ActionReceiver): Comparison {
        logger.debug("criterion={} criterionIndex={} receiver={}", criterion, criterionIndex, receiver)
        return criterion.compare(receiver)
    }

    private fun getComparisons(criteria: List<Criterion>, receiver: ActionReceiver): List<Comparison> {
        logger.debug("criteria.size={} receiver={}", criteria.size, receiver)
        return criteria.mapIndexed { criterionIndex, criterion ->
            getComparison(criterion, criterionIndex, receiver)
        }
    }

    override fun toString(): String {
        return "{criteria=${criteria} hashCode=${hashCode()} match=${match}}"
    }
}