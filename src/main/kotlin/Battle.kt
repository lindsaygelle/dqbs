package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class Battle(actors: List<Actor>, timeMilliseconds: Long, uuid: UUID) : TimeMeasurer,
    TurnsAccumulator,
    UniversalIdentifier {
    var actors: List<Actor> = actors
        set(value) {
            field = value.distinctBy { battler -> battler.hashCode() }
            logger.trace("actors={} actors.size={}", field, field.size)
        }

    @Transient
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    override var timeMilliseconds: Long = timeMilliseconds
        set(value) {
            field = maxOf(0, value)
            logger.trace("timeMilliseconds={}", field)
        }

    override var turns: Int = 0
        set(value) {
            field = maxOf(0, value)
            logger.trace("turns={}", field)
        }

    override var uuid: UUID = uuid
        set(value) {
            field = value
            logger.trace("uuid={}", field)
        }

    init {
        this.actors = actors
        this.timeMilliseconds = timeMilliseconds
        this.turns = turns
        this.uuid = uuid
    }

    private fun filterActor(actor: Actor): Boolean {
        return actor.hitPoints > 0
    }

    private fun filterActors(actors: List<Actor>): List<Actor> {
        return actors.filter { actor -> filterActor(actor) }
    }

    private fun sortActor(actor: Actor): Int {
        return actor.agility
    }

    private fun sortActors(actors: List<Actor>): List<Actor> {
        return actors.sortedByDescending { actor -> sortActor(actor) }
    }

    fun tick() {
        var actors = filterActors(actors)
        actors = sortActors(actors)
        tickActors(actors)
        turns++
    }

    private fun tickActor(actor: Actor, actorIndex: Int, actors: List<Actor>) {
        actor.act(actors)
    }

    private fun tickActors(actors: List<Actor>) {
        val actorsIterator = actors.withIndex().iterator()
        while (actorsIterator.hasNext()) {
            val (actorIndex, actor) = actorsIterator.next()
            tickActor(actor, actorIndex, actors)
        }
    }
}