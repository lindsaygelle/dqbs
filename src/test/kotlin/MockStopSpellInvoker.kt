import com.github.lindsaygelle.StopSpellInvoker
import java.util.UUID

class MockStopSpellInvoker(
    override var magicPoints: Int,
    override var stopSpellRequirementMaximum: Int,
    override var stopSpellRequirementMinimum: Int,
    override var uuid: UUID,
) : StopSpellInvoker