import com.github.lindsaygelle.dqbs.Actor
import java.util.*

class MockActor(
    override val agility: Int,
    override var allegiance: Int,
    override var magicPoints: Int,
    override val strength: Int,
    override var uuid: UUID,
) : Actor