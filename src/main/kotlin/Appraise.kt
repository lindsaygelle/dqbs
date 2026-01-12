package com.github.lindsaygelle

import java.util.*

class Appraise<T : ActionReceiver>(rules: List<Rule<T>>) : Consider<T, Appraisal>(rules) {
    override fun getConsideration(assessments: List<Assessment>, receivers: List<T>): Appraisal {
        return Appraisal(assessments, receivers.isNotEmpty(), System.currentTimeMillis(), UUID.randomUUID())
    }
}