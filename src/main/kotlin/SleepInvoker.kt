package com.github.lindsaygelle.dqbs

interface SleepInvoker : MagicInvoker {
    var sleepRequirementMaximum: Int
    var sleepRequirementMinimum: Int
}