import com.github.lindsaygelle.dqbs.*
import java.util.*
import kotlin.random.Random
import kotlin.test.Test

class WeighTest {
    @Test
    fun test() {
        val actors = mutableListOf<Actor>()
        for (i in 0..Random.nextInt(5, 10)) {
            val agility = (0..i + 1).random()
            val allegiance = (0..1).random()
            val magicPoints = (0..1).random()
            val strength = (0..i + 1).random()
            val actor: Actor = MockActor(allegiance, agility, magicPoints, strength, UUID.randomUUID())
            actors.add(actor)
        }
        val comparisons = mutableListOf<com.github.lindsaygelle.dqbs.Comparison<Actor>>()
        for (i in 0..Random.nextInt(5, 10)) {
            val attribute = Attribute.entries.random()
            val operation = Operation.entries.random()
            val value = Random.nextInt(0, i + 1)
            val criterion = Comparison<Actor>(
                attribute, operation, value, UUID.randomUUID(),
            )
            comparisons.add(criterion)
        }
        val tracers = mutableListOf<Tracer>()
        val weigh = Weigh<Actor>(comparisons, UUID.randomUUID())
        weigh.sort(actors, tracers)

        tracers.forEach { tracer ->
            println(tracer)
        }
    }
}