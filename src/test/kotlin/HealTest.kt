import com.github.lindsaygelle.dqbs.Heal
import com.github.lindsaygelle.dqbs.HealInvoker
import com.github.lindsaygelle.dqbs.HealReceiver
import com.github.lindsaygelle.dqbs.Tracer
import kotlin.random.Random
import kotlin.test.Test

class HealTest {
    @Test
    fun test() {
        val receivers = mutableListOf<HealReceiver>()
        for (i in 1..10) {
            receivers.add(MockBattler() as HealReceiver)
        }
        val heal = Heal<HealInvoker, HealReceiver>(Random.nextInt(1, 3), 1)
        val tracers = mutableListOf<Tracer>()
        heal.use(MockBattler() as HealInvoker, receivers, tracers)
        tracers.forEach { tracer ->
            println(tracer)
        }
    }
}