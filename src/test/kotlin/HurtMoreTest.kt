import com.github.lindsaygelle.Armor
import com.github.lindsaygelle.HurtMore
import com.github.lindsaygelle.HurtReceiver
import java.util.*
import kotlin.random.Random
import kotlin.test.Test

class HurtMoreTest {
    @Test
    fun test() {
        val limit = Random.nextInt(1, 10)
        val magicPoints = Random.nextInt(0, 100)
        val hurtMore = HurtMore(limit, magicPoints)
        val invoker = MockHurtMoreInvoker(Random.nextInt(0, magicPoints * 2), 1, 16, 16, 0, 16, 0, UUID.randomUUID())
        val receivers = mutableListOf<HurtReceiver>()
        for (i in 0..Random.nextInt(3, 100)) {
            var armor: Armor? = null
            if (listOf(true, false).random()) {
                armor = Armor(false, false,Random.nextInt(0, 10), Random.nextInt(0, 10), "TEST", UUID.randomUUID())
            }
            receivers.add(MockHurtReceiver(armor, Random.nextInt(1, 100), 16, 0, UUID.randomUUID()))
        }
        val outcomes = hurtMore.use(invoker, receivers)
        print(outcomes)
    }
}