package com.github.lindsaygelle

import java.util.*

class Score(
    evaluations: List<Evaluation>, receiverUUID: UUID, timeMilliseconds: Long, uuid: UUID, value: Int,
) : Evaluatable(evaluations, receiverUUID, timeMilliseconds, uuid),
    Valuer {
    override var value: Int = value
        set(value) {
            field = value
            logger.trace("value={}", field)
        }

    init {
        this.value = value
    }
}