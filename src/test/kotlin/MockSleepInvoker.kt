import com.github.lindsaygelle.SleepInvoker
import java.util.*
import kotlin.random.Random

class MockSleepInvoker(
    override var magicPoints: Int = Random.nextInt(0, 100),
    override var sleepRequirementMaximum: Int = 16,
    override var sleepRequirementMinimum: Int = 0,
    override var uuid: UUID = UUID.randomUUID(),
) : SleepInvoker