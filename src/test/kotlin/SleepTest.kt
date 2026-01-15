import com.github.lindsaygelle.dqbs.Sleep
import com.github.lindsaygelle.dqbs.SleepInvoker
import com.github.lindsaygelle.dqbs.SleepReceiver
import com.github.lindsaygelle.dqbs.Tracer
import kotlin.random.Random
import kotlin.test.Test

class SleepTest {
    @Test
    fun test() {
        val receivers = mutableListOf<SleepReceiver>()
        for (i in 1..10) {
            receivers.add(MockBattler() as SleepReceiver)
        }
        val sleep = Sleep<SleepInvoker, SleepReceiver>(Random.nextInt(1, 3), 1)
        val tracers = mutableListOf<Tracer>()
        sleep.use(MockBattler() as SleepInvoker, receivers, tracers)
        tracers.forEach { tracer ->
            println(tracer)
        }
    }
}