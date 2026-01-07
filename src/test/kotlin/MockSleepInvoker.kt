import com.github.lindsaygelle.SleepInvoker
import java.util.*

class MockSleepInvoker(
    override var magicPoints: Int,
    override var sleepRequirementMaximum: Int,
    override var sleepRequirementMinimum: Int,
    override var uuid: UUID,
) : SleepInvoker