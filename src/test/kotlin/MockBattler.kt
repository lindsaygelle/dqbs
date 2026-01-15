import com.github.lindsaygelle.dqbs.Action
import com.github.lindsaygelle.dqbs.Actor
import com.github.lindsaygelle.dqbs.Battler
import java.util.*
import kotlin.random.Random

class MockBattler(
    override var actions: Collection<Action<Actor, Actor>> = listOf(),
    override val agility: Int = Random.nextInt(0, 10),
    override var allegiance: Int = Random.nextInt(0, 10),
    override var healMoreScale: Int = 4,
    override var healMoreShift: Int = 4,
    override var healRangeMaximum: Int = 16,
    override var healRangeMinimum: Int = 0,
    override var healScale: Int = 4,
    override var healShift: Int = 4,
    override var hitPoints: Int = Random.nextInt(0, 10),
    override var magicPoints: Int = Random.nextInt(0, 10),
    override var sleepRequirementMaximum: Int = 1,
    override var sleepRequirementMinimum: Int = 0,
    override var sleepResistanceMaximum: Int = 1,
    override var sleepResistanceMinimum: Int = 0,
    override var statusSleep: Boolean = Random.nextBoolean(),
    override var statusStopSpell: Boolean = Random.nextBoolean(),
    override var stopSpellResistanceMaximum: Int = 1,
    override var stopSpellResistanceMinimum: Int = 0,
    override var stopSpellRequirementMaximum: Int = 1,
    override var stopSpellRequirementMinimum: Int = 0,
    override val strength: Int = Random.nextInt(0, 10),
    override val uuid: UUID = UUID.randomUUID(),
) : Battler