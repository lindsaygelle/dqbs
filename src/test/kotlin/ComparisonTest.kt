import com.github.lindsaygelle.dqbs.*
import kotlin.random.Random
import kotlin.test.Test

class ComparisonTest {
    @Test
    fun test() {
        val attribute = Attribute.entries.random()
        val operation = Operation.entries.random()
        val value = Random.nextInt(0, 100)
        val comparison = Comparison<Actor>(attribute, operation, value)
        val receiver: Actor = MockBattler()
        val tracers = mutableListOf<Tracer>()
        comparison.check(receiver, tracers)
        println(tracers)
    }
}