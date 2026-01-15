import com.github.lindsaygelle.dqbs.*
import kotlin.random.Random
import kotlin.test.Test

class ActionTest {
    @Test
    fun test() {
        val action: Action<Actor, Actor> = Action(
            ability = Sleep(
                limit = Random.nextInt(1, 10), magicCost = 0
            ),
            assess = Qualify(
                cases = listOf(
                    Case(
                        rules = listOf(
                            Rule(
                                comparisons = listOf(
                                    Comparison(
                                        Attribute.entries.random(),
                                        Operation.entries.random(),
                                        (0..1).random(),
                                    )
                                ),
                                match = Match.entries.random(),
                            ),
                        ),
                        selections = listOf(Selection.entries.random()),
                    )
                )
            ),
            choose = Qualify(
                listOf(
                    Case(
                        rules = listOf(
                            Rule(
                                comparisons = listOf(
                                    Comparison(
                                        Attribute.entries.random(),
                                        Operation.entries.random(),
                                        (0..1).random(),
                                    )
                                ),
                                match = Match.entries.random(),
                            ),
                        ),
                        selections = listOf(Selection.entries.random()),
                    )
                )
            ),
            priority = 0,
            weigh = Weigh(
                comparisons = listOf(
                    Comparison(
                        Attribute.entries.random(),
                        Operation.entries.random(),
                        Random.nextInt(0, 1),
                    )
                ),
            ),
        )
        val receivers = mutableListOf<Actor>()
        for (i in 1..10) {
            val receiver: Actor = MockBattler()
            receivers.add(receiver)
        }
        val tracer = mutableListOf<Tracer>()
        action.use(receivers.random(), receivers, tracer)
        tracer.forEach { tracer ->
            println(tracer)
        }
    }
}