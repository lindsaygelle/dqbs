package com.github.lindsaygelle.dqbs

import java.util.UUID

data class RuleBegin(
    override var match: Match,
    override var receiverUUID: UUID,
    override var ruleUUID: UUID,
    override var timeMilliseconds: Long,
    override var uuid: UUID
): RuleTracer
