package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Measure(
    criteria: Collection<Criterion>
) {
    var criteria: Collection<Criterion> = criteria
        set(value) {
            field = value
            logger.trace("criteria={} hashCode={}", field, hashCode())
        }

    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    init {
        this.criteria = criteria
    }

    fun check(requester: Requester, provider: Provider): MeasureContext {
        val timeMilliseconds = System.currentTimeMillis()
        val criterionContexts = getCriterionContexts(requester, provider)
        val result = checkCriterionContexts(criterionContexts)
        val measureContext = getMeasureContext(criterionContexts, result, timeMilliseconds)
        return measureContext
    }

    private fun checkCriterionContext(criterionContext: CriterionContext, criterionContextIndex: Int): Boolean {
        logger.debug(
            "criterionContext={} criterionContextIndex={} hashCode={}",
            criterionContext,
            criterionContextIndex,
            hashCode()
        )
        return criterionContext.result
    }

    private fun checkCriterionContexts(criterionContexts: Collection<CriterionContext>): Boolean {
        return criterionContexts.withIndex().any { (criterionContextIndex, criterionContext) ->
            checkCriterionContext(criterionContext, criterionContextIndex)
        }
    }

    private fun getCriterionContext(
        criterion: Criterion,
        criterionIndex: Int,
        requester: Requester,
        provider: Provider
    ): CriterionContext {
        logger.debug(
            "criterion={} criterionIndex={} requester={} provider={} hashCode={}",
            criterion,
            criterionIndex,
            requester,
            provider,
            hashCode()
        )
        val criterionContext = criterion.check(requester, provider)
        return criterionContext
    }

    private fun getCriterionContexts(
        requester: Requester,
        provider: Provider
    ): Collection<CriterionContext> {
        return criteria.withIndex()
            .map { (criteriaIndex, criteria) -> getCriterionContext(criteria, criteriaIndex, requester, provider) }
    }

    private fun getMeasureContext(
        criterionContexts: Collection<CriterionContext>,
        result: Boolean,
        timeMilliseconds: Long
    ): MeasureContext {
        logger.debug(
            "criterionContexts={} result={} timeMilliseconds={} hashCode={}",
            criterionContexts,
            result,
            timeMilliseconds,
            hashCode()
        )
        return MeasureContext(criterionContexts, result, timeMilliseconds)
    }

    override fun toString(): String {
        return "{criteria=${criteria} hashCode=${hashCode()}}"
    }
}
