package com.github.lindsaygelle

interface StopSpellReceiver : AbilityReceiver,
    StopSpellResister {
    var statusStopSpell: Boolean
}