package com.github.lindsaygelle

import java.util.UUID

interface AbilityContext : Context {
    var invokerCheck: Boolean
    var invokerUUID: UUID
    var receiverCheck: Boolean
    var receiverUUID: UUID
}