import com.github.lindsaygelle.dqbs.HealMore
import com.github.lindsaygelle.dqbs.HealMoreInvoker
import com.github.lindsaygelle.dqbs.HealReceiver
import com.github.lindsaygelle.dqbs.Tracer
import kotlin.random.Random
import kotlin.test.Test

class HealMoreTest {
    @Test
    fun test() {
        val receivers = mutableListOf<HealReceiver>()
        for (i in 1..10) {
            receivers.add(MockBattler() as HealReceiver)
        }
        val healMore = HealMore<HealMoreInvoker, HealReceiver>(Random.nextInt(1, 3), 1)
        val tracers = mutableListOf<Tracer>()
        healMore.use(MockBattler() as HealMoreInvoker, receivers, tracers)
        tracers.forEach { tracer ->
            println(tracer)
        }
    }
}