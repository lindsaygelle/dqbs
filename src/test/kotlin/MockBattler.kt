import com.github.lindsaygelle.dqbs.Action
import com.github.lindsaygelle.dqbs.Actor
import com.github.lindsaygelle.dqbs.Battler
import java.util.*

class MockBattler(
    override var actions: Collection<Action<Actor, Actor>>,
    override val agility: Int,
    override var allegiance: Int,
    override var magicPoints: Int,
    override val strength: Int,
    override var uuid: UUID,
) : Battler