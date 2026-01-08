import com.github.lindsaygelle.HealMoreInvoker
import java.util.UUID

class MockHealMoreInvoker(
    override var healMoreScale: Int,
    override var healMoreShift: Int,
    override var healRangeMaximum: Int,
    override var healRangeMinimum: Int,
    override var magicPoints: Int,
    override var uuid: UUID,
) : HealMoreInvoker