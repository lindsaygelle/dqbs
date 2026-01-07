package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class Outcome<C : Check, E : Effect, I : Invocation, R : Reception>(
    check: C,
    effect: E,
    invocation: I,
    invokerUUID: UUID,
    receiverIndex: Int,
    receiverUUID: UUID,
    reception: R,
    timeMilliseconds: Long,
    uuid: UUID,
) : TimeMeasurer,
    UniversalIdentifier {
    var check: C = check
        set(value) {
            field = value
            logger.trace("check={}", field)
        }
    var effect: E = effect
        set(value) {
            field = value
            logger.trace("effect={}", field)
        }
    var invocation: I = invocation
        set(value) {
            field = value
            logger.trace("invocation={}", field)
        }
    var invokerUUID: UUID = invokerUUID
        set(value) {
            field = value
            logger.trace("invokerUUID={}", field)
        }

    @Transient
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    var receiverIndex: Int = receiverIndex
        set(value) {
            field = value
            logger.trace("receiverIndex={}", field)
        }
    var receiverUUID: UUID = receiverUUID
        set(value) {
            field = value
            logger.trace("receiverUUID={}", field)
        }
    var reception: R = reception
        set(value) {
            field = value
            logger.trace("reception={}", field)
        }
    override var timeMilliseconds: Long = timeMilliseconds
        set(value) {
            field = value
            logger.trace("timeMilliseconds={}", field)
        }
    override var uuid: UUID = uuid
        set(value) {
            field = value
            logger.trace("uuid={}", field)
        }

    init {
        this.check = check
        this.effect = effect
        this.invocation = invocation
        this.invokerUUID = invokerUUID
        this.receiverIndex = receiverIndex
        this.receiverUUID = receiverUUID
        this.reception = reception
        this.timeMilliseconds = timeMilliseconds
        this.uuid = uuid
    }

    override fun toString(): String {
        return "{check=${check} effect=${effect} hashCode=${hashCode()} invocation=${invocation} invokerUUID=${invokerUUID} receiverIndex=${receiverIndex} receiverUUID=${receiverUUID} reception=${reception} timeMilliseconds=${timeMilliseconds} uuid=${uuid}}"
    }
}