import com.github.lindsaygelle.HurtMoreInvoker
import java.util.UUID

class MockHurtMoreInvoker(
    override var magicPoints: Int,
    override var hurtMoreScale: Int,
    override var hurtMoreShift: Int,
    override var hurtRangeMaximum: Int,
    override var hurtRangeMinimum: Int,
    override var hurtRequirementMaximum: Int,
    override var hurtRequirementMinimum: Int,
    override var uuid: UUID,
) : HurtMoreInvoker