package com.github.lindsaygelle

interface BattleInvoker : AttackInvoker,
    HealInvoker,
    HurtInvoker,
    SleepInvoker,
    StopSpellInvoker