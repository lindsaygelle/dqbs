package com.github.lindsaygelle

import java.util.*

class Assessment(
    evaluations: List<Evaluation>, receiverUUID: UUID, result: Boolean, timeMilliseconds: Long, uuid: UUID,
) : Evaluatable(evaluations, receiverUUID, timeMilliseconds, uuid) {
    var result: Boolean = result
        set(value) {
            field = value
            logger.trace("result={}", field)
        }

    init {
        this.result = result
    }
}