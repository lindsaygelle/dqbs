package com.github.lindsaygelle

class SleepReception(sleepResistance: Int, sleepResistanceMaximum: Int, sleepResistanceMinimum: Int) : Reception() {
    var sleepResistance: Int = sleepResistance
        set(value) {
            field = value
            logger.trace("sleepResistance={}", field)
        }
    var sleepResistanceMaximum: Int = sleepResistanceMaximum
        set(value) {
            field = value
            logger.trace("sleepResistanceMaximum={}", field)
        }
    var sleepResistanceMinimum: Int = sleepResistanceMinimum
        set(value) {
            field = value
            logger.trace("sleepResistanceMinimum={}", field)
        }

    init {
        this.sleepResistance = sleepResistance
        this.sleepResistanceMaximum = sleepResistanceMaximum
        this.sleepResistanceMinimum = sleepResistanceMinimum
    }
}
