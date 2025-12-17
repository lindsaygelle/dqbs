package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

open class Actor(
    actions: List<Action>,
    agility: Int,
    allegiance: Int,
    armor: Armor?,
    healRangeMaximum: Int,
    healRangeMinimum: Int,
    healScale: Int,
    healShift: Int,
    hitPoints: Int,
    hitPointsMaximum: Int,
    hurtRangeMaximum: Int,
    hurtRangeMinimum: Int,
    hurtResistanceMaximum: Int,
    hurtResistanceMinimum: Int,
    hurtScale: Int,
    hurtShift: Int,
    index: Int,
    magicPoints: Int,
    magicPointsMaximum: Int,
    name: String,
    sleepRequirementMaximum: Int,
    sleepRequirementMinimum: Int,
    sleepResolutionMaximum: Int,
    sleepResolutionMinimum: Int,
    sleepResistanceMaximum: Int,
    sleepResistanceMinimum: Int,
    statusSleep: Boolean,
    statusStopSpell: Boolean,
    stopSpellResolutionMaximum: Int,
    stopSpellResolutionMinimum: Int,
    stopSpellRequirementMaximum: Int,
    stopSpellRequirementMinimum: Int,
    stopSpellResistanceMaximum: Int,
    stopSpellResistanceMinimum: Int,
    strength: Int,
    turns: Int,
    turnsSleep: Int,
    turnsSleepMaximum: Int,
    turnsSleepMinimum: Int,
    turnsStopSpell: Int,
    turnsStopSpellMaximum: Int,
    turnsStopSpellMinimum: Int,
    uuid: UUID,
) : Battler {
    override var actions: List<Action> = actions
        set(value) {
            field = value
            logger.trace("actions={}", field)
        }
    override var agility: Int = agility
        set(value) {
            field = value
            logger.trace("agility={}", field)
        }
    override var allegiance: Int = allegiance
        set(value) {
            field = value
            logger.trace("allegiance={}", field)
        }
    override var armor: Armor? = armor
        set(value) {
            field = value
            logger.trace("armor={}", field)
        }
    override var healRangeMaximum: Int = healRangeMaximum
        set(value) {
            field = value
            logger.trace("healRangeMaximum={}", field)
        }
    override var healRangeMinimum: Int = healRangeMinimum
        set(value) {
            field = value
            logger.trace("healRangeMinimum={}", field)
        }
    override var healScale: Int = healScale
        set(value) {
            field = value
            logger.trace("healScale={}", field)
        }
    override var healShift: Int = healShift
        set(value) {
            field = value
            logger.trace("healShift={}", field)
        }
    override var hitPoints: Int = hitPoints
        set(value) {
            field = value
            logger.trace("hitPoints={}", field)
        }
    override var hitPointsMaximum: Int = hitPointsMaximum
        set(value) {
            field = value
            logger.trace("hitPointsMaximum={}", field)
        }
    override var hurtRangeMaximum: Int = hurtRangeMaximum
        set(value) {
            field = value
            logger.trace("hurtRangeMaximum={}", field)
        }
    override var hurtRangeMinimum: Int = hurtRangeMinimum
        set(value) {
            field = value
            logger.trace("hurtRangeMinimum={}", field)
        }
    override var hurtResistanceMaximum: Int = hurtResistanceMaximum
        set(value) {
            field = value
            logger.trace("hurtResistanceMaximum={}", field)
        }
    override var hurtResistanceMinimum: Int = hurtResistanceMinimum
        set(value) {
            field = value
            logger.trace("hurtResistanceMinimum={}", field)
        }
    override var hurtScale: Int = hurtScale
        set(value) {
            field = value
            logger.trace("hurtScale={}", field)
        }
    override var hurtShift: Int = hurtShift
        set(value) {
            field = value
            logger.trace("hurtShift={}", field)
        }
    override var index: Int = index
        set(value) {
            field = value
            logger.trace("index={}", field)
        }
    protected val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    override var magicPoints: Int = magicPoints
        set(value) {
            field = value
            logger.trace("magicPoints={}", field)
        }
    override var magicPointsMaximum: Int = magicPointsMaximum
        set(value) {
            field = value
            logger.trace("magicPointsMaximum={}", field)
        }
    override var name: String = name
        set(value) {
            field = value
            logger.trace("name={}", field)
        }
    override var sleepRequirementMaximum: Int = sleepRequirementMaximum
        set(value) {
            field = value
            logger.trace("sleepRequirementMaximum={}", field)
        }
    override var sleepRequirementMinimum: Int = sleepRequirementMinimum
        set(value) {
            field = value
            logger.trace("sleepRequirementMinimum={}", field)
        }
    override var sleepResolutionMaximum: Int = sleepResolutionMaximum
        set(value) {
            field = value
            logger.trace("sleepResolutionMaximum={}", field)
        }
    override var sleepResolutionMinimum: Int = sleepResolutionMinimum
        set(value) {
            field = value
            logger.trace("sleepResolutionMinimum={}", field)
        }
    override var sleepResistanceMaximum: Int = sleepResistanceMaximum
        set(value) {
            field = value
            logger.trace("sleepResistanceMaximum={}", field)
        }
    override var sleepResistanceMinimum: Int = sleepResistanceMinimum
        set(value) {
            field = value
            logger.trace("sleepResistanceMinimum={}", field)
        }
    override var statusSleep: Boolean = statusSleep
        set(value) {
            field = value
            logger.trace("statusSleep={}", field)
        }
    override var statusStopSpell: Boolean = statusStopSpell
        set(value) {
            field = value
            logger.trace("statusStopSpell={}", field)
        }
    override var stopSpellResolutionMaximum: Int = stopSpellResolutionMaximum
        set(value) {
            field = value
            logger.trace("stopSpellResolutionMaximum={}", field)
        }
    override var stopSpellResolutionMinimum: Int = stopSpellResolutionMinimum
        set(value) {
            field = value
            logger.trace("stopSpellResolutionMinimum={}", field)
        }
    override var stopSpellRequirementMaximum: Int = stopSpellRequirementMaximum
        set(value) {
            field = value
            logger.trace("stopSpellRequirementMaximum={}", field)
        }
    override var stopSpellRequirementMinimum: Int = stopSpellRequirementMinimum
        set(value) {
            field = value
            logger.trace("stopSpellRequirementMinimum={}", field)
        }
    override var stopSpellResistanceMaximum: Int = stopSpellResistanceMaximum
        set(value) {
            field = value
            logger.trace("stopSpellResistanceMaximum={}", field)
        }
    override var stopSpellResistanceMinimum: Int = stopSpellResistanceMinimum
        set(value) {
            field = value
            logger.trace("stopSpellResistanceMinimum={}", field)
        }
    override var strength: Int = strength
        set(value) {
            field = value
            logger.trace("strength={}", field)
        }
    override var turns: Int = turns
        set(value) {
            field = value
            logger.trace("turns={}", field)
        }
    override var turnsSleep: Int = turnsSleep
        set(value) {
            field = value
            logger.trace("turnsSleep={}", field)
        }
    override var turnsSleepMaximum: Int = turnsSleepMaximum
        set(value) {
            field = value
            logger.trace("turnsSleepMaximum={}", field)
        }
    override var turnsSleepMinimum: Int = turnsSleepMinimum
        set(value) {
            field = value
            logger.trace("turnsSleepMinimum={}", field)
        }
    override var turnsStopSpell: Int = turnsStopSpell
        set(value) {
            field = value
            logger.trace("turnsStopSpell={}", field)
        }
    override var turnsStopSpellMaximum: Int = turnsStopSpellMaximum
        set(value) {
            field = value
            logger.trace("turnsStopSpellMaximum={}", field)
        }
    override var turnsStopSpellMinimum: Int = turnsStopSpellMinimum
        set(value) {
            field = value
            logger.trace("turnsStopSpellMinimum={}", field)
        }
    override var uuid: UUID = uuid
        set(value) {
            field = value
            logger.trace("uuid={}", field)
        }

    init {
        this.actions = actions
        this.agility = agility
        this.allegiance = allegiance
        this.armor = armor
        this.healRangeMaximum = healRangeMaximum
        this.healRangeMinimum = healRangeMinimum
        this.healScale = healScale
        this.healShift = healShift
        this.hitPoints = hitPoints
        this.hitPointsMaximum = hitPointsMaximum
        this.hurtRangeMaximum = hurtRangeMaximum
        this.hurtRangeMinimum = hurtRangeMinimum
        this.hurtResistanceMaximum = hurtResistanceMaximum
        this.hurtResistanceMinimum = hurtResistanceMinimum
        this.hurtScale = hurtScale
        this.hurtShift = hurtShift
        this.index = index
        this.magicPoints = magicPoints
        this.magicPointsMaximum = magicPointsMaximum
        this.name = name
        this.sleepRequirementMaximum = sleepRequirementMaximum
        this.sleepRequirementMinimum = sleepRequirementMinimum
        this.sleepResolutionMaximum = sleepResolutionMaximum
        this.sleepResolutionMinimum = sleepResolutionMinimum
        this.sleepResistanceMaximum = sleepResistanceMaximum
        this.sleepResistanceMinimum = sleepResistanceMinimum
        this.statusSleep = statusSleep
        this.statusStopSpell = statusStopSpell
        this.stopSpellResolutionMaximum = stopSpellResolutionMaximum
        this.stopSpellResolutionMinimum = stopSpellResolutionMinimum
        this.stopSpellRequirementMaximum = stopSpellRequirementMaximum
        this.stopSpellRequirementMinimum = stopSpellRequirementMinimum
        this.stopSpellResistanceMaximum = stopSpellResistanceMaximum
        this.stopSpellResistanceMinimum = stopSpellResistanceMinimum
        this.strength = strength
        this.turns = turns
        this.turnsSleep = turnsSleep
        this.turnsSleepMaximum = turnsSleepMaximum
        this.turnsSleepMinimum = turnsSleepMinimum
        this.turnsStopSpell = turnsStopSpell
        this.turnsStopSpellMaximum = turnsStopSpellMaximum
        this.turnsStopSpellMinimum = turnsStopSpellMinimum
        this.uuid = uuid
    }
}
