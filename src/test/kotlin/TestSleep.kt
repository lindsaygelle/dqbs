import com.github.lindsaygelle.Sleep
import com.github.lindsaygelle.SleepReceiver
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

class TestSleep {
    @Test
    fun test() {
        val limit = Random.nextInt(1, 10)
        val magicPoints = Random.nextInt(0, 100)
        val sleep = Sleep(limit, magicPoints)
        val invoker = MockSleepInvoker()
        val receivers = mutableListOf<SleepReceiver>()
        for (i in 0..Random.nextInt(3, 100)) {
            receivers.add(MockSleepReceiver())
        }
        val outcomes = sleep.use(invoker, receivers)
        assertEquals(limit, outcomes.size)
    }
}