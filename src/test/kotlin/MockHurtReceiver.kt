import com.github.lindsaygelle.Armor
import com.github.lindsaygelle.HurtReceiver
import java.util.UUID

class MockHurtReceiver(
    override var armor: Armor?,
    override var hitPoints: Int,
    override var hurtResistanceMaximum: Int,
    override var hurtResistanceMinimum: Int,
    override var uuid: UUID,
) : HurtReceiver