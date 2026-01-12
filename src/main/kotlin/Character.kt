package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

open class Character(
    actions: List<Action>,
    agility: Int,
    allegiance: Int,
    armor: Armor?,
    healMoreScale: Int,
    healMoreShift: Int,
    healRangeMaximum: Int,
    healRangeMinimum: Int,
    healScale: Int,
    healShift: Int,
    herbRangeMaximum: Int,
    herbRangeMinimum: Int,
    herbScale: Int,
    herbShift: Int,
    hitPoints: Int,
    hitPointsMaximum: Int,
    hurtMoreScale: Int,
    hurtMoreShift: Int,
    hurtRangeMaximum: Int,
    hurtRangeMinimum: Int,
    hurtRequirementMaximum: Int,
    hurtRequirementMinimum: Int,
    hurtResistanceMaximum: Int,
    hurtResistanceMinimum: Int,
    hurtScale: Int,
    hurtShift: Int,
    index: Int,
    items: MutableMap<Item, Int>,
    magicPoints: Int,
    magicPointsMaximum: Int,
    name: String,
    shield: Shield?,
    sleepRequirementMaximum: Int,
    sleepRequirementMinimum: Int,
    sleepResistanceMaximum: Int,
    sleepResistanceMinimum: Int,
    sleepResolutionMaximum: Int,
    sleepResolutionMinimum: Int,
    sleepResolvable: SleepResolvable,
    statusSleep: Boolean,
    statusStopSpell: Boolean,
    stopSpellRequirementMaximum: Int,
    stopSpellRequirementMinimum: Int,
    stopSpellResistanceMaximum: Int,
    stopSpellResistanceMinimum: Int,
    stopSpellResolutionMaximum: Int,
    stopSpellResolutionMinimum: Int,
    stopSpellResolvable: StopSpellResolvable,
    strength: Int,
    turns: Int,
    turnsSleep: Int,
    turnsSleepMaximum: Int,
    turnsSleepMinimum: Int,
    turnsStopSpell: Int,
    turnsStopSpellMaximum: Int,
    turnsStopSpellMinimum: Int,
    uuid: UUID,
    weapon: Weapon?,
) : Actor {
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

    override var healMoreScale: Int = healMoreScale
        set(value) {
            field = maxOf(0, value)
            logger.trace("healMoreScale={}", field)
        }

    override var healMoreShift: Int = healMoreShift
        set(value) {
            field = maxOf(0, value)
            logger.trace("healMoreShift={}", field)
        }

    override var healRangeMaximum: Int = healRangeMaximum
        set(value) {
            field = maxOf(0, value)
            logger.trace("healRangeMaximum={}", field)
        }

    override var healRangeMinimum: Int = healRangeMinimum
        set(value) {
            field = minOf(maxOf(0, value), healRangeMaximum)
            logger.trace("healRangeMinimum={}", field)
        }

    override var healScale: Int = healScale
        set(value) {
            field = maxOf(0, value)
            logger.trace("healScale={}", field)
        }

    override var healShift: Int = healShift
        set(value) {
            field = maxOf(0, value)
            logger.trace("healShift={}", field)
        }

    override var herbRangeMaximum: Int = herbRangeMaximum
        set(value) {
            field = maxOf(0, value)
            logger.trace("herbRangeMaximum={}", field)
        }

    override var herbRangeMinimum: Int = herbRangeMinimum
        set(value) {
            field = minOf(maxOf(0, value), herbRangeMaximum)
            logger.trace("herbRangeMinimum={}", field)
        }

    override var herbScale: Int = herbScale
        set(value) {
            field = maxOf(0, value)
            logger.trace("herbScale={}", field)
        }

    override var herbShift: Int = herbShift
        set(value) {
            field = maxOf(0, value)
            logger.trace("herbShift={}", field)
        }

    override var hitPoints: Int = hitPoints
        set(value) {
            field = minOf(maxOf(0, value), hitPointsMaximum)
            logger.trace("hitPoints={}", field)
        }

    override var hitPointsMaximum: Int = hitPointsMaximum
        set(value) {
            field = maxOf(0, value)
            logger.trace("hitPointsMaximum={}", field)
        }

    override var hurtMoreScale: Int = hurtMoreScale
        set(value) {
            field = maxOf(0, value)
            logger.trace("hurtMoreScale={}", field)
        }

    override var hurtMoreShift: Int = hurtMoreShift
        set(value) {
            field = maxOf(0, value)
            logger.trace("hurtMoreShift={}", field)
        }

    override var hurtRangeMaximum: Int = hurtRangeMaximum
        set(value) {
            field = maxOf(0, value)
            logger.trace("hurtRangeMaximum={}", field)
        }

    override var hurtRequirementMaximum: Int = hurtRequirementMaximum
        set(value) {
            field = maxOf(0, value)
            logger.trace("hurtRequirementMaximum={}", field)
        }

    override var hurtRequirementMinimum: Int = hurtRequirementMinimum
        set(value) {
            field = minOf(maxOf(0, value), hurtRequirementMaximum)
            logger.trace("hurtRequirementMinimum={}", field)
        }

    override var hurtRangeMinimum: Int = hurtRangeMinimum
        set(value) {
            field = minOf(maxOf(0, value), hurtRangeMaximum)
            logger.trace("hurtRangeMinimum={}", field)
        }

    override var hurtResistanceMaximum: Int = hurtResistanceMaximum
        set(value) {
            field = maxOf(0, value)
            logger.trace("hurtResistanceMaximum={}", field)
        }

    override var hurtResistanceMinimum: Int = hurtResistanceMinimum
        set(value) {
            field = minOf(maxOf(0, value), hurtResistanceMaximum)
            logger.trace("hurtResistanceMinimum={}", field)
        }

    override var hurtScale: Int = hurtScale
        set(value) {
            field = maxOf(0, value)
            logger.trace("hurtScale={}", field)
        }

    override var hurtShift: Int = hurtShift
        set(value) {
            field = maxOf(0, value)
            logger.trace("hurtShift={}", field)
        }

    override var index: Int = index
        set(value) {
            field = value
            logger.trace("index={}", field)
        }

    override var items: MutableMap<Item, Int> = items
        set(value) {
            field = value
            logger.trace("items={}", field)
        }

    @Transient
    protected val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    override var magicPoints: Int = magicPoints
        set(value) {
            field = minOf(maxOf(0, value), magicPointsMaximum)
            logger.trace("magicPoints={}", field)
        }

    override var magicPointsMaximum: Int = magicPointsMaximum
        set(value) {
            field = maxOf(0, value)
            logger.trace("magicPointsMaximum={}", field)
        }

    override var name: String = name
        set(value) {
            field = value
            logger.trace("name={}", field)
        }

    override var shield: Shield? = shield
        set(value) {
            field = value
            logger.trace("shield={}", field)
        }

    override var sleepRequirementMaximum: Int = sleepRequirementMaximum
        set(value) {
            field = maxOf(0, value)
            logger.trace("sleepRequirementMaximum={}", field)
        }

    override var sleepRequirementMinimum: Int = sleepRequirementMinimum
        set(value) {
            field = minOf(maxOf(0, value), sleepRequirementMaximum)
            logger.trace("sleepRequirementMinimum={}", field)
        }

    override var sleepResistanceMaximum: Int = sleepResistanceMaximum
        set(value) {
            field = maxOf(0, value)
            logger.trace("sleepResistanceMaximum={}", field)
        }

    override var sleepResistanceMinimum: Int = sleepResistanceMinimum
        set(value) {
            field = minOf(maxOf(0, value), sleepResistanceMaximum)
            logger.trace("sleepResistanceMinimum={}", field)
        }

    override var sleepResolutionMaximum: Int = sleepResolutionMaximum
        set(value) {
            field = maxOf(0, value)
            logger.trace("sleepResolutionMaximum={}", field)
        }

    override var sleepResolutionMinimum: Int = sleepResolutionMinimum
        set(value) {
            field = minOf(maxOf(0, value), sleepResolutionMaximum)
            logger.trace("sleepResolutionMinimum={}", field)
        }

    @Transient
    var sleepResolvable: SleepResolvable = sleepResolvable
        set(value) {
            field = value
            logger.trace("sleepResolvable={}", field)
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

    override var stopSpellRequirementMaximum: Int = stopSpellRequirementMaximum
        set(value) {
            field = maxOf(0, value)
            logger.trace("stopSpellRequirementMaximum={}", field)
        }

    override var stopSpellRequirementMinimum: Int = stopSpellRequirementMinimum
        set(value) {
            field = minOf(maxOf(0, value), stopSpellRequirementMaximum)
            logger.trace("stopSpellRequirementMinimum={}", field)
        }

    override var stopSpellResistanceMaximum: Int = stopSpellResistanceMaximum
        set(value) {
            field = maxOf(0, value)
            logger.trace("stopSpellResistanceMaximum={}", field)
        }

    override var stopSpellResistanceMinimum: Int = stopSpellResistanceMinimum
        set(value) {
            field = minOf(maxOf(0, value), stopSpellResistanceMaximum)
            logger.trace("stopSpellResistanceMinimum={}", field)
        }

    override var stopSpellResolutionMaximum: Int = stopSpellResolutionMaximum
        set(value) {
            field = maxOf(0, value)
            logger.trace("stopSpellResolutionMaximum={}", field)
        }

    override var stopSpellResolutionMinimum: Int = stopSpellResolutionMinimum
        set(value) {
            field = minOf(maxOf(0, value), stopSpellResolutionMaximum)
            logger.trace("stopSpellResolutionMinimum={}", field)
        }

    @Transient
    var stopSpellResolvable: StopSpellResolvable = stopSpellResolvable
        set(value) {
            field = value
            logger.trace("stopSpellResolvable={}", field)
        }

    override var strength: Int = strength
        set(value) {
            field = maxOf(0, value)
            logger.trace("strength={}", field)
        }

    override var turns: Int = turns
        set(value) {
            field = maxOf(0, value)
            logger.trace("turns={}", field)
        }

    override var turnsSleep: Int = turnsSleep
        set(value) {
            field = maxOf(0, value)
            logger.trace("turnsSleep={}", field)
        }

    override var turnsSleepMaximum: Int = turnsSleepMaximum
        set(value) {
            field = maxOf(0, value)
            logger.trace("turnsSleepMaximum={}", field)
        }

    override var turnsSleepMinimum: Int = turnsSleepMinimum
        set(value) {
            field = minOf(maxOf(0, value), turnsSleepMaximum)
            logger.trace("turnsSleepMinimum={}", field)
        }

    override var turnsStopSpell: Int = turnsStopSpell
        set(value) {
            field = maxOf(0, value)
            logger.trace("turnsStopSpell={}", field)
        }

    override var turnsStopSpellMaximum: Int = turnsStopSpellMaximum
        set(value) {
            field = maxOf(0, value)
            logger.trace("turnsStopSpellMaximum={}", field)
        }

    override var turnsStopSpellMinimum: Int = turnsStopSpellMinimum
        set(value) {
            field = minOf(maxOf(0, value), turnsStopSpellMaximum)
            logger.trace("turnsStopSpellMinimum={}", field)
        }

    override var uuid: UUID = uuid
        set(value) {
            field = value
            logger.trace("uuid={}", field)
        }

    override var weapon: Weapon? = weapon
        set(value) {
            field = value
            logger.trace("weapon={}", field)
        }

    init {
        this.actions = actions
        this.agility = agility
        this.allegiance = allegiance
        this.armor = armor
        this.healMoreScale = healMoreScale
        this.healMoreShift = healMoreShift
        this.healRangeMaximum = healRangeMaximum
        this.healRangeMinimum = healRangeMinimum
        this.healScale = healScale
        this.healShift = healShift
        this.herbRangeMaximum = herbRangeMaximum
        this.herbRangeMinimum = herbRangeMinimum
        this.herbScale = herbScale
        this.herbShift = herbShift
        this.hitPoints = hitPoints
        this.hitPointsMaximum = hitPointsMaximum
        this.hurtMoreScale = hurtMoreScale
        this.hurtMoreShift = hurtMoreShift
        this.hurtRangeMaximum = hurtRangeMaximum
        this.hurtRangeMinimum = hurtRangeMinimum
        this.hurtRequirementMaximum = hurtRequirementMaximum
        this.hurtRequirementMinimum = hurtRequirementMinimum
        this.hurtResistanceMaximum = hurtResistanceMaximum
        this.hurtResistanceMinimum = hurtResistanceMinimum
        this.hurtScale = hurtScale
        this.hurtShift = hurtShift
        this.index = index
        this.items = items
        this.magicPoints = magicPoints
        this.magicPointsMaximum = magicPointsMaximum
        this.name = name
        this.shield = shield
        this.sleepRequirementMaximum = sleepRequirementMaximum
        this.sleepRequirementMinimum = sleepRequirementMinimum
        this.sleepResistanceMaximum = sleepResistanceMaximum
        this.sleepResistanceMinimum = sleepResistanceMinimum
        this.sleepResolutionMaximum = sleepResolutionMaximum
        this.sleepResolutionMinimum = sleepResolutionMinimum
        this.sleepResolvable = sleepResolvable
        this.statusSleep = statusSleep
        this.statusStopSpell = statusStopSpell
        this.stopSpellRequirementMaximum = stopSpellRequirementMaximum
        this.stopSpellRequirementMinimum = stopSpellRequirementMinimum
        this.stopSpellResistanceMaximum = stopSpellResistanceMaximum
        this.stopSpellResistanceMinimum = stopSpellResistanceMinimum
        this.stopSpellResolutionMaximum = stopSpellResolutionMaximum
        this.stopSpellResolutionMinimum = stopSpellResolutionMinimum
        this.stopSpellResolvable = stopSpellResolvable
        this.strength = strength
        this.turns = turns
        this.turnsSleep = turnsSleep
        this.turnsSleepMaximum = turnsSleepMaximum
        this.turnsSleepMinimum = turnsSleepMinimum
        this.turnsStopSpell = turnsStopSpell
        this.turnsStopSpellMaximum = turnsStopSpellMaximum
        this.turnsStopSpellMinimum = turnsStopSpellMinimum
        this.uuid = uuid
        this.weapon = weapon
    }

    final override fun getActivities(receivers: List<ActionReceiver>): List<Activity> {
        logger.debug("receivers.size={}", receivers.size)
        // TODO
        val activities = mutableListOf<Activity>()
        for (action in actions) {
            val activity = action.use(this, receivers)
            activities.add(activity)
            if (activity.outcomes?.isNotEmpty() == true) {
                break
            }
        }
        return activities
    }

    final override fun getAttribute(attribute: Attribute): Int {
        logger.debug("attribute={}", attribute)
        return when (attribute) {
            Attribute.AGILITY -> hitPoints
            Attribute.HIT_POINTS -> hitPoints
            Attribute.HIT_POINTS_PERCENTAGE -> hitPointsPercentage
            Attribute.HIT_POINTS_MAXIMUM -> hitPointsMaximum
            Attribute.MAGIC_POINTS -> magicPoints
            Attribute.MAGIC_POINTS_MAXIMUM -> magicPointsMaximum
            Attribute.MAGIC_POINTS_PERCENTAGE -> magicPointsPercentage
            Attribute.STRENGTH -> strength
        }
    }
}