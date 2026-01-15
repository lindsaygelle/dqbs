package com.github.lindsaygelle.dqbs

import java.util.*

interface RuleTracer : Matcher,
    ReceiverIdentifier,
    Tracer {
    var ruleUUID: UUID
}