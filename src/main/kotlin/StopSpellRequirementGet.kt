package com.github.lindsaygelle.dqbs

import java.util.*

data class StopSpellRequirementGet(
    val stopSpellRequirementMaximum: Int,
    val stopSpellRequirementMinimum: Int,
    val stopSpellRequirement: Int,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : ReceiverTracer