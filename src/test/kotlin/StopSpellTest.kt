import com.github.lindsaygelle.dqbs.StopSpell
import com.github.lindsaygelle.dqbs.StopSpellInvoker
import com.github.lindsaygelle.dqbs.StopSpellReceiver
import com.github.lindsaygelle.dqbs.Tracer
import kotlin.random.Random
import kotlin.test.Test

class StopSpellTest {
    @Test
    fun test() {
        val receivers = mutableListOf<StopSpellReceiver>()
        for (i in 1..10) {
            receivers.add(MockBattler() as StopSpellReceiver)
        }
        val stopSpell = StopSpell<StopSpellInvoker, StopSpellReceiver>(Random.nextInt(1, 3), 1)
        val tracers = mutableListOf<Tracer>()
        stopSpell.use(MockBattler() as StopSpellInvoker, receivers, tracers)
        tracers.forEach { tracer ->
            println(tracer)
        }
    }
}