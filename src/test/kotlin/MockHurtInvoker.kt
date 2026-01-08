import com.github.lindsaygelle.HurtInvoker
import java.util.UUID

class MockHurtInvoker(
    override var hurtRangeMaximum: Int,
    override var hurtRangeMinimum: Int,
    override var hurtRequirementMaximum: Int,
    override var hurtRequirementMinimum: Int,
    override var hurtScale: Int,
    override var hurtShift: Int,
    override var magicPoints: Int,
    override var uuid: UUID,
) : HurtInvoker