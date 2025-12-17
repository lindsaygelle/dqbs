package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.UUID

class BattlerContext(
    allegiance: Int,
    agility: Int,
    armor: Armor?,
    hitPoints: Int,
    hitPointsMaximum: Int,
    index: Int,
    items: MutableMap<Item, Int>,
    magicPoints: Int,
    magicPointsMaximum: Int,
    name: String,
    turnsSleep: Int,
    turnsSleepMaximum: Int,
    turnsSleepMinimum: Int,
    strength: Int,
    turnsStopSpell: Int,
    turnsStopSpellMaximum: Int,
    turnsStopSpellMinimum: Int,
    timeMilliseconds: Long,
    turns: Int,
    uuid: UUID,
) : AllegianceKeeper,
    AgilityPointer,
    ArmorWearer,
    HitPointer,
    HitPointerMaximizer,
    Indexable,
    Itemizer,
    MagicPointer,
    MagicPointMaximizer,
    Nameable,
    SleepLimiter,
    StrengthPointer,
    StopSpellLimiter,
    TimeMeasurer,
    TurnsAccumulator,
UniversalIdentifier {
    override var allegiance: Int = allegiance
        set(value) {
            field = value
            logger.trace("allegiance={}", field)
        }
    override var agility: Int = agility
        set(value) {
            field = value
            logger.trace("agility={}", field)
        }
    override var armor: Armor? = armor
        set(value) {
            field = value
            logger.trace("armor={}", field)
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
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
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
    override var strength: Int = strength
        set(value) {
            field = value
            logger.trace("strength={}", field)
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
    override var timeMilliseconds: Long = timeMilliseconds
        set(value) {
            field = value
            logger.trace("timeMilliseconds={}", field)
        }
    override var turns: Int = turns
        set(value) {
            field = value
            logger.trace("turns={}", field)
        }
    override var uuid: UUID = uuid
        set(value) {
            field = value
            logger.trace("uuid={}", uuid)
        }

    init {
        this.allegiance = allegiance
        this.agility = agility
        this.armor = armor
        this.hitPoints = hitPoints
        this.hitPointsMaximum = hitPointsMaximum
        this.index = index
        this.items = items
        this.magicPoints = magicPoints
        this.magicPointsMaximum = magicPointsMaximum
        this.name = name
        this.turnsSleep = turnsSleep
        this.turnsSleepMaximum = turnsSleepMaximum
        this.turnsSleepMinimum = turnsSleepMinimum
        this.strength = strength
        this.turnsStopSpell = turnsStopSpell
        this.turnsStopSpellMaximum = turnsStopSpellMaximum
        this.turnsStopSpellMinimum = turnsStopSpellMinimum
        this.timeMilliseconds = timeMilliseconds
        this.turns = turns
        this.uuid = uuid
    }
}
