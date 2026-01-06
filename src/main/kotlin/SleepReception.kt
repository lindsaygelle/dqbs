package com.github.lindsaygelle

class SleepReception(sleepResistance: Int, sleepResistanceMaximum: Int, sleepResistanceMinimum: Int) : Reception() {
    var sleepResistance: Int = sleepResistance
    var sleepResistanceMaximum: Int = sleepResistanceMaximum
    var sleepResistanceMinimum: Int = sleepResistanceMinimum

    init {
        this.sleepResistance = sleepResistance
        this.sleepResistanceMaximum = sleepResistanceMaximum
        this.sleepResistanceMinimum = sleepResistanceMinimum
    }
}
