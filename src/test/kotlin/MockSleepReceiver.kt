import com.github.lindsaygelle.SleepReceiver
import java.util.UUID
import kotlin.random.Random

class MockSleepReceiver(
    override var sleepResistanceMaximum: Int = 16,
    override var sleepResistanceMinimum: Int = 0,
    override var statusSleep: Boolean = false,
    override var turnsSleep: Int = Random.nextInt(0, 10),
    override var uuid: UUID = UUID.randomUUID(),
) : SleepReceiver