import com.github.lindsaygelle.dqbs.*
import kotlin.random.Random
import kotlin.test.Test

class WeighTest {
    @Test
    fun test() {
        val actors = mutableListOf<Actor>()
        for (i in 0..Random.nextInt(5, 10)) {
            val actor: Actor = MockBattler()
            actors.add(actor)
        }
        val comparisons = mutableListOf<Comparison<Actor>>()
        for (i in 0..Random.nextInt(5, 10)) {
            val attribute = Attribute.entries.random()
            val operation = Operation.entries.random()
            val value = Random.nextInt(0, i + 1)
            val criterion = Comparison<Actor>(
                attribute, operation, value,
            )
            comparisons.add(criterion)
        }
        val tracers = mutableListOf<Tracer>()
        val weigh = Weigh(comparisons)
        weigh.sort(actors, tracers)

        tracers.forEach { tracer ->
            println(tracer)
        }
    }
}