package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class Criterion(
    comparisons: Collection<Comparison>, match: Match, priority: Int, uuid: UUID
) : Identifier {
    var comparisons: Collection<Comparison> = comparisons
        set(value) {
            field = value
            logger.trace("aspects={} hashCode={}", field, hashCode())
        }

    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    var match: Match = match
        set(value) {
            field = value
            logger.trace("match={} hashCode={}", field, hashCode())
        }

    var priority: Int = priority
        set(value) {
            field = value
            logger.trace("priority={} hashCode={}", field, hashCode())
        }

    override var uuid: UUID = uuid
        set(value) {
            field = value
            logger.trace("uuid={} hashCode={}", field, hashCode())
        }

    init {
        this.comparisons = comparisons.sortedBy { aspect -> aspect.priority }
        this.match = match
        this.uuid = uuid
    }

    fun check(requester: Requester, provider: Provider): CriterionContext {
        logger.debug("requester={} provider={} hashCode={}", requester, provider, hashCode())
        val timeMilliseconds = System.currentTimeMillis()
        val comparisonContexts = getComparisonContexts(requester, provider)
        val result = checkMatch(comparisonContexts)
        val criterionContext = getCriterionContext(comparisonContexts, result, timeMilliseconds)
        return criterionContext
    }

    private fun checkComparisonContext(comparisonContext: ComparisonContext, comparisonContextIndex: Int): Boolean {
        logger.debug(
            "comparisonContext={} comparisonContextIndex={} hashCode={}",
            comparisonContext,
            comparisonContextIndex,
            hashCode(),
        )
        return comparisonContext.result
    }

    private fun checkComparisonContexts(callable: ((IndexedValue<ComparisonContext>) -> Boolean) -> Boolean): Boolean {
        return callable { (index, value) ->
            checkComparisonContext(value, index)
        }
    }

    private fun checkMatch(comparisonContexts: Collection<ComparisonContext>): Boolean {
        val iterable: Iterable<IndexedValue<ComparisonContext>> = comparisonContexts.withIndex()
        return when (match) {
            Match.ALL -> checkMatchAll(iterable)
            Match.ANY -> checkMatchAny(iterable)
        }
    }

    private fun checkMatchAll(iterable: Iterable<IndexedValue<ComparisonContext>>): Boolean {
        return checkComparisonContexts(iterable::all)
    }

    private fun checkMatchAny(iterable: Iterable<IndexedValue<ComparisonContext>>): Boolean {
        return checkComparisonContexts(iterable::any)
    }

    private fun getCriterionContext(
        comparisonContexts: Collection<ComparisonContext>,
        result: Boolean,
        timeMilliseconds: Long,
    ): CriterionContext {
        logger.debug(
            "comparisonContexts={} result={} timeMilliseconds={} hashCode={}",
            comparisonContexts,
            result,
            timeMilliseconds,
            hashCode()
        )
        return CriterionContext(
            comparisonContexts = comparisonContexts,
            match = match,
            result = result,
            timeMilliseconds = timeMilliseconds
        )
    }

    private fun getComparisonContext(
        comparison: Comparison,
        comparisonIndex: Int,
        requester: Requester,
        provider: Provider
    ): ComparisonContext {
        logger.debug(
            "comparison={} comparisonIndex={} requester={} provider={} hashCode={}",
            comparison,
            comparisonIndex,
            requester,
            provider,
            hashCode()
        )
        return comparison.check(requester, provider)
    }

    private fun getComparisonContexts(requester: Requester, provider: Provider): Collection<ComparisonContext> {
        return comparisons.withIndex().map { (comparisonIndex, comparison) ->
            getComparisonContext(
                comparison,
                comparisonIndex,
                requester,
                provider
            )
        }
    }

    override fun toString(): String {
        return "{comparisons=${comparisons} match=${match} priority=${priority} uuid=${uuid} hashCode=${hashCode()}}"
    }
}
