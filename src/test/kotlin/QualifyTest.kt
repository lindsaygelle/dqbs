import com.github.lindsaygelle.dqbs.*
import kotlin.test.Test

class QualifyTest {
    @Test
    fun test() {
        val receivers = mutableListOf<Actor>()
        for (i in 1..10) {
            val receiver: Actor = MockBattler()
            receivers.add(receiver)
        }
        val cases = mutableListOf<Case<Actor, Actor>>()
        for (i in 1..10) {
            val rules = mutableListOf<Rule<Actor>>()
            for (i in 1..10) {
                val comparisons = mutableListOf<Comparison<Actor>>()
                for (i in 1..10) {
                    val attribute = Attribute.entries.random()
                    val operation = Operation.entries.random()
                    val value = i
                    val comparison = Comparison<Actor>(
                        attribute, operation, value,
                    )
                    comparisons.add(comparison)
                }
                val match = Match.entries.random()
                val rule = Rule<Actor>(
                    comparisons, match,
                )
                rules.add(rule)
            }
            val selections = mutableListOf<Selection>()
            selections.add(Selection.entries.random())
            val case = Case<Actor, Actor>(rules, selections)
            cases.add(case)
        }
        val qualify = Qualify<Actor, Actor>(
            cases = cases
        )
        val tracers = mutableListOf<Tracer>()
        qualify.filter(MockBattler(), receivers, tracers)
        tracers.forEach { tracer ->
            println(tracer)
        }
    }
}