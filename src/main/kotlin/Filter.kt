package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Filter(measure: Measure) {

    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    var measure: Measure = measure
        set(value) {
            field = value
            logger.trace("measure={} hashCode={}", field, hashCode())
        }

    init {
        this.measure = measure
    }

    fun filter(requester: Requester, providers: Collection<Provider>): FilterContext {
        val timeMilliseconds = System.currentTimeMillis()
        val (result, filteredProviders, filterDetails) = filterProviders(requester, providers)
        val filterContext = getFilterContext(filterDetails, filteredProviders, result,timeMilliseconds)
        return filterContext
    }

    private fun filterProvider(requester: Requester, provider: Provider, providerIndex: Int): FilterDetail {
        val measureContext = getMeasureContext(requester, provider, providerIndex)
        val filterDetail = getFilterDetail(measureContext, provider, providerIndex)
        return filterDetail
    }

    private fun filterProviders(
        requester: Requester,
        providers: Collection<Provider>
    ): Triple<Boolean, Collection<Provider>, Collection<FilterDetail>> {
        val filterDetails = mutableListOf<FilterDetail>()
        val filteredProviders = mutableListOf<Provider>()
        providers.forEachIndexed { providerIndex, provider ->
            val filterDetail = filterProvider(requester, provider, providerIndex)
            filterDetails.add(filterDetail)
            if (filterDetail.measureContext.result) {
                filteredProviders.add(provider)
            }
        }
        val result = providers.isNotEmpty()
        val triple: Triple<Boolean, Collection<Provider>, Collection<FilterDetail>> = Triple(result, filteredProviders, filterDetails)
        return triple
    }

    private fun getFilterContext(
        filterDetails: Collection<FilterDetail>,
        providers: Collection<Provider>,
        result: Boolean,
        timeMilliseconds: Long
    ): FilterContext {
        return FilterContext(filterDetails, providers, result, timeMilliseconds)
    }

    private fun getFilterDetail(measureContext: MeasureContext, provider: Provider, providerIndex: Int): FilterDetail {
        val filterDetail = FilterDetail(measureContext, provider, providerIndex)
        return filterDetail
    }

    private fun getMeasureContext(
        requester: Requester,
        provider: Provider,
        providerIndex: Int
    ): MeasureContext {
        logger.debug("requester={} provider={} providerIndex={}", requester, providerIndex, providerIndex)
        return measure.check(requester, provider)
    }

    override fun toString(): String {
        return "{measure=${measure} hashCode=${hashCode()}}"
    }
}
