package com.github.lindsaygelle.dqbs

interface StopSpellReceiver : AbilityReceiver {
    var statusStopSpell: Boolean
    var stopSpellResistanceMaximum: Int
    var stopSpellResistanceMinimum: Int
}