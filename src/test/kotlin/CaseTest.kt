import com.github.lindsaygelle.dqbs.*
import java.util.*
import kotlin.test.Test

class CaseTest {
    @Test
    fun test() {
        val receivers = mutableListOf<Actor>()
        for (i in 1..10) {
            val agility = (0..i + 1).random()
            val allegiance = (0..1).random()
            val magicPoints = (0..1).random()
            val strength = (0..i + 1).random()
            val receiver: Actor = MockActor(allegiance, agility, magicPoints, strength, UUID.randomUUID())
            receivers.add(receiver)
        }
        val rules = mutableListOf<Rule<Actor>>()
        for (i in 1..10) {
            val comparisons = mutableListOf<com.github.lindsaygelle.dqbs.Comparison<Actor>>()
            for (i in 1..10) {
                val attribute = Attribute.entries.random()
                val operation = Operation.entries.random()
                val value = i
                val comparison = Comparison<Actor>(
                    attribute, operation, value, UUID.randomUUID(),
                )
                comparisons.add(comparison)
            }
            val match = Match.entries.random()
            val rule = Rule<Actor>(
                comparisons, match, UUID.randomUUID(),
            )
            rules.add(rule)
        }
        val selections = mutableListOf<Selection>()
        selections.add(Selection.entries.random())
        val case = Case<Actor, Actor>(rules, selections, UUID.randomUUID())
        val tracers = mutableListOf<Tracer>()
        case.filter(receivers.random(),receivers, tracers)
        tracers.forEach { tracer ->
            println(tracer)
        }
    }
}