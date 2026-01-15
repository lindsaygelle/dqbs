import com.github.lindsaygelle.dqbs.Actor
import com.github.lindsaygelle.dqbs.Attribute
import com.github.lindsaygelle.dqbs.Comparison
import com.github.lindsaygelle.dqbs.Operation
import com.github.lindsaygelle.dqbs.Tracer
import java.util.*
import kotlin.random.Random
import kotlin.test.Test

class Comparison {
    @Test
    fun test() {
        val attribute = Attribute.entries.random()
        val operation = Operation.entries.random()
        val value = Random.nextInt(0, 100)
        val uuid = UUID.randomUUID()
        val comparison = Comparison<Actor>(attribute, operation, value, uuid)
        val agility = Random.nextInt()
        val allegiance = Random.nextInt()
        val magicPoints = Random.nextInt()
        val strength = Random.nextInt()
        val receiver: Actor = MockActor(allegiance, agility, magicPoints, strength, UUID.randomUUID())
        val tracers = mutableListOf<Tracer>()
        comparison.check(receiver, tracers)
        println(tracers)
    }
}