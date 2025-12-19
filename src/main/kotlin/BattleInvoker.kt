package com.github.lindsaygelle

interface BattleInvoker : AttackInvoker,
    HealInvoker,
    HerbInvoker,
    HurtInvoker,
    SleepInvoker,
    StopSpellInvoker
