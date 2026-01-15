package com.github.lindsaygelle.dqbs

interface Battler : Actor {
    var actions: Collection<Action<Actor, Actor>>
}