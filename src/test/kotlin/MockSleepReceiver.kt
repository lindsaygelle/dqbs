import com.github.lindsaygelle.Armor
import com.github.lindsaygelle.SleepReceiver
import java.util.*

class MockSleepReceiver(
    override var armor: Armor?,
    override var sleepResistanceMaximum: Int,
    override var sleepResistanceMinimum: Int,
    override var statusSleep: Boolean,
    override var turnsSleep: Int,
    override var uuid: UUID,
) : SleepReceiver