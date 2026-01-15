package com.github.lindsaygelle.dqbs

interface StopSpellInvoker : MagicInvoker {
    var stopSpellRequirementMaximum: Int
    var stopSpellRequirementMinimum: Int
}