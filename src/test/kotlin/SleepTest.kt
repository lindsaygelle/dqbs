import com.github.lindsaygelle.Armor
import com.github.lindsaygelle.Sleep
import com.github.lindsaygelle.SleepReceiver
import java.util.*
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

class SleepTest {
    @Test
    fun test() {
        val limit = Random.nextInt(1, 10)
        val magicPoints = Random.nextInt(0, 100)
        val sleep = Sleep(limit, magicPoints)
        val invoker = MockSleepInvoker(Random.nextInt(0, magicPoints * 2), 16, 0, UUID.randomUUID())
        val receivers = mutableListOf<SleepReceiver>()
        for (i in 0..Random.nextInt(3, 100)) {
            var armor: Armor? = null
            if (listOf(true, false).random()) {
                armor = Armor(listOf(true, false).random(), false, 0, 0, "TEST", UUID.randomUUID())
            }
            receivers.add(MockSleepReceiver(armor, 16, 0, false, Random.nextInt(0, 10), UUID.randomUUID()))
        }
        val outcomes = sleep.use(invoker, receivers)
        print(outcomes)
        assertEquals(limit, outcomes.size)
    }
}