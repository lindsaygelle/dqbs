package com.github.lindsaygelle

class SleepInvocation(sleepRequirement: Int, sleepRequirementMaximum: Int, sleepRequirementMinimum: Int) :
    Invocation() {
    var sleepRequirement: Int = sleepRequirement
        set(value) {
            field = value
            logger.trace("sleepRequirement={}", field)
        }
    var sleepRequirementMaximum: Int = sleepRequirementMaximum
        set(value) {
            field = value
            logger.trace("sleepRequirementMaximum={}", field)
        }
    var sleepRequirementMinimum: Int = sleepRequirementMinimum
        set(value) {
            field = value
            logger.trace("sleepRequirementMinimum={}", field)
        }

    init {
        this.sleepRequirement = sleepRequirement
        this.sleepRequirementMaximum = sleepRequirementMaximum
        this.sleepRequirementMinimum = sleepRequirementMinimum
    }
}
