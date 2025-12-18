package com.github.lindsaygelle

class StopSpell(limit: Int, magicPoints: Int) :
    MagicAbility<StopSpellInvoker, StopSpellReceiver, StopSpellContext>(limit, magicPoints)
