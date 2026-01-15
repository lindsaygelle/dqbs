package com.github.lindsaygelle.dqbs

import java.util.UUID

data class AbilityEnd(
    override var abilityUUID: UUID,
    override var invokerUUID: UUID,
    override var name: String,
    var result: Boolean,
    override var timeMilliseconds: Long,
    override var uuid: UUID,
): AbilityTracer
