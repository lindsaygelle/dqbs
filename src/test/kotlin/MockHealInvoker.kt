import com.github.lindsaygelle.HealInvoker
import java.util.*

class MockHealInvoker(
    override var healScale: Int,
    override var healShift: Int,
    override var healRangeMaximum: Int,
    override var healRangeMinimum: Int,
    override var magicPoints: Int,
    override var uuid: UUID,
) : HealInvoker