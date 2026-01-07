import com.github.lindsaygelle.StopSpellReceiver
import java.util.*

class MockStopSpellReceiver(
    override var stopSpellResistanceMaximum: Int,
    override var stopSpellResistanceMinimum: Int,
    override var statusStopSpell: Boolean,
    override var turnsStopSpell: Int,
    override var uuid: UUID,
) : StopSpellReceiver