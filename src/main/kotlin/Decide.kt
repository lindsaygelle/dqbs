package com.github.lindsaygelle

import java.util.*

class Decide(rules: List<Rule>) : Consider<Decision>(rules) {
    override fun getConsideration(assessments: List<Assessment>, receivers: List<ActionReceiver>): Decision {
        return Decision(assessments, receivers.isNotEmpty(), System.currentTimeMillis(), UUID.randomUUID())
    }
}