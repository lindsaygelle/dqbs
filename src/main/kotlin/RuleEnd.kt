package com.github.lindsaygelle.dqbs

import java.util.*

data class RuleEnd(
    override var match: Match,
    override var receiverUUID: UUID,
    var result: Boolean,
    override var ruleUUID: UUID,
    override var timeMilliseconds: Long,
    override var uuid: UUID,
) : RuleTracer,
    Matcher