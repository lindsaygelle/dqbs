import com.github.lindsaygelle.HealInvocable
import java.util.*
import kotlin.test.Test

class HealInvocableTest {
    @Test
    fun test() {
        val invoker = MockHealInvoker(1, 0, 16, 0, 10, UUID.randomUUID())
        val invocable = HealInvocable(10)
        val invocation = invocable.invoke(invoker)
        print(invocation)
    }
}