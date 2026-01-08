import com.github.lindsaygelle.HealMore
import com.github.lindsaygelle.HealReceiver
import java.util.*
import kotlin.random.Random
import kotlin.test.Test

class HealMoreTest {
    @Test
    fun test() {
        val limit = Random.nextInt(1, 10)
        val magicPoints = Random.nextInt(0, 100)
        val healMore = HealMore(limit, magicPoints)
        val invoker = MockHealMoreInvoker(
            Random.nextInt(), Random.nextInt(), 16, 0, Random.nextInt(0, magicPoints * 2), UUID.randomUUID()
        )
        val receivers = mutableListOf<HealReceiver>()
        for (i in 0..Random.nextInt(3, 100)) {
            receivers.add(MockHealReceiver(Random.nextInt(1, 100), UUID.randomUUID()))
        }
        val outcomes = healMore.use(invoker, receivers)
        print(outcomes)
    }
}