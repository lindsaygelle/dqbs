package com.github.lindsaygelle.dqbs

interface Battler : Actor {
    var actions: Collection<Action<Actor, Actor>>
    var sleepResolutionMaximum: Int
    var sleepResolutionMinimum: Int
    var stopSpellResolutionMaximum: Int
    var stopSpellResolutionMinimum: Int
    var turnsSleep: Int
    var turnsSleepMaximum: Int
    var turnsSleepMinimum: Int
    var turnsStopSpell: Int
    var turnsStopSpellMaximum: Int
    var turnsStopSpellMinimum: Int
}