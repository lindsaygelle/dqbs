package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class FilterContext(
    filterDetails: Collection<FilterDetail>,
    providers: Collection<Provider>,
    result: Boolean,
    timeMilliseconds: Long
) {
    var filterDetails: Collection<FilterDetail> = filterDetails
        set(value) {
            field = value
            logger.trace("filterDetails={} hashCode={}", field, hashCode())
        }

    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    var providers: Collection<Provider> = providers
        set(value) {
            field = value
            logger.trace("providers={} hashCode={}", field, hashCode())
        }

    var result: Boolean = result
        set(value) {
            field = value
            logger.trace("result={} hashCode={}", field, hashCode())
        }

    var timeMilliseconds: Long = timeMilliseconds
        set(value) {
            field = value
            logger.trace("timeMilliseconds={} hashCode={}", field, hashCode())
        }

    init {
        this.filterDetails = filterDetails
        this.providers = providers
        this.result = result
        this.timeMilliseconds = timeMilliseconds
    }

    override fun toString(): String {
        return "{filterDetails=${filterDetails} providers=${providers} result=${result} timeMilliseconds=${timeMilliseconds} hashCode=${hashCode()}}"
    }
}
