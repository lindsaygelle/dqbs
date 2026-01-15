import com.github.lindsaygelle.dqbs.*
import java.util.*
import kotlin.random.Random
import kotlin.test.Test

class ActionTest {
    @Test
    fun test() {
        val action: Action<Actor, Actor> = Action(
            ability = Ability(
                limit = Random.nextInt(1, 10), uuid = UUID.randomUUID()
            ),
            assess = Case(
                rules = listOf(
                    Rule(
                        comparisons = listOf(
                            Comparison(
                                Attribute.entries.random(),
                                Operation.entries.random(),
                                (0..1).random(),
                                UUID.randomUUID(),
                            )
                        ),
                        match = Match.entries.random(),
                        uuid = UUID.randomUUID(),
                    ),
                ),
                selections = listOf(Selection.entries.random()),
                uuid = UUID.randomUUID(),
            ),
            choose = Case(
                rules = listOf(
                    Rule(
                        comparisons = listOf(
                            Comparison(
                                Attribute.entries.random(),
                                Operation.entries.random(),
                                (0..1).random(),
                                UUID.randomUUID(),
                            )
                        ),
                        match = Match.entries.random(),
                        uuid = UUID.randomUUID(),
                    ),
                ),
                selections = listOf(Selection.entries.random()),
                uuid = UUID.randomUUID(),
            ),
            weigh = Weigh(
                comparisons = listOf(
                    Comparison(
                        Attribute.entries.random(),
                        Operation.entries.random(),
                        Random.nextInt(),
                        UUID.randomUUID(),
                    )
                ),
                uuid = UUID.randomUUID(),
            ),
            uuid = UUID.randomUUID(),
        )
        val receivers = mutableListOf<Actor>()
        for (i in 1..10) {
            val receiver: Actor = MockActor(
                (0..1).random(), 1, 1, 1,UUID.randomUUID(),
            )
            receivers.add(receiver)
        }
        val tracer = mutableListOf<Tracer>()
        action.use(receivers.random(), receivers, tracer)
        tracer.forEach { tracer ->
            println(tracer)
        }
    }
}