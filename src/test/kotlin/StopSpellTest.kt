import com.github.lindsaygelle.Armor
import com.github.lindsaygelle.StopSpell
import com.github.lindsaygelle.StopSpellReceiver
import java.util.*
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

class StopSpellTest {
    @Test
    fun test() {
        val limit = Random.nextInt(1, 10)
        val magicPoints = Random.nextInt(0, 100)
        val stopSpell = StopSpell(limit, magicPoints)
        val invoker = MockStopSpellInvoker(Random.nextInt(0, magicPoints * 2), 16, 0, UUID.randomUUID())
        val receivers = mutableListOf<StopSpellReceiver>()
        for (i in 0..Random.nextInt(3, 100)) {
            var armor: Armor? = null
            if (listOf(true, false).random()) {
                armor = Armor(false, listOf(true, false).random(), 0, 0, "TEST", UUID.randomUUID())
            }
            receivers.add(MockStopSpellReceiver(armor, 16, 0, false, Random.nextInt(0, 10), UUID.randomUUID()))
        }
        val outcomes = stopSpell.use(invoker, receivers)
        print(outcomes)
        assertEquals(limit, outcomes.size)
    }
}