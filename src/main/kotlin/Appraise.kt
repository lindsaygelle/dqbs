package com.github.lindsaygelle

import java.util.*

class Appraise(rules: List<Rule>) : Consider<Appraisal>(rules) {
    override fun getConsideration(assessments: List<Assessment>, receivers: List<ActionReceiver>): Appraisal {
        return Appraisal(assessments, receivers.isNotEmpty(), System.currentTimeMillis(), UUID.randomUUID())
    }
}