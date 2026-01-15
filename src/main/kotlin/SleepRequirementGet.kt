package com.github.lindsaygelle.dqbs

import java.util.*

data class SleepRequirementGet(
    val sleepRequirement: Int,
    val sleepRequirementMaximum: Int,
    val sleepRequirementMinimum: Int,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : ReceiverTracer