package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class FilterDetail(measureContext: MeasureContext, provider: Provider, providerIndex: Int) {
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    var measureContext: MeasureContext = measureContext
        set(value) {
            field = value
            logger.trace("measureContext={} hashCode={}", field, hashCode())
        }

    var providerIndex: Int = providerIndex
        set(value) {
            field = value
            logger.trace("providerIndex={} hashCode={}", field, hashCode())
        }

    var providerUUID: UUID = provider.uuid
        set(value) {
            field = value
            logger.trace("providerUUID={} hashCode={}", field, hashCode())
        }

    init {
        this.measureContext = measureContext
        this.providerIndex = providerIndex
        this.providerUUID = providerUUID
    }

    override fun toString(): String {
        return "{measureContext=${measureContext} providerIndex=${providerIndex} providerUUID=${providerUUID} hashCode=${hashCode()}"
    }
}
