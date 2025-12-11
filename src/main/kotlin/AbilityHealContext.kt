package com.github.lindsaygelle

import java.util.UUID

class AbilityHealContext(
    override var invokerCheck: Boolean,
    override var invokerUUID: UUID,
    override var receiverCheck: Boolean,
    override var receiverUUID: UUID,
) : AbilityContext