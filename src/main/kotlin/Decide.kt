package com.github.lindsaygelle

import java.util.*

class Decide<T : AttributeReceiver>(rules: List<Rule<T>>) : Consider<T, Decision>(rules) {
    override fun getConsideration(assessments: List<Assessment>, receivers: List<T>): Decision {
        return Decision(assessments, receivers.isNotEmpty(), System.currentTimeMillis(), UUID.randomUUID())
    }
}