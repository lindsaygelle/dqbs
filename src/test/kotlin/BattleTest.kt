import com.github.lindsaygelle.dqbs.Action
import com.github.lindsaygelle.dqbs.Actor
import com.github.lindsaygelle.dqbs.Battle
import com.github.lindsaygelle.dqbs.Battler
import java.util.*
import kotlin.test.Test

class BattleTest {
    @Test
    fun test() {
        val invokers = mutableListOf<Battler>()
        for (i in 1..10) {
            val actions = listOf<Action<Actor, Actor>>()
            val agility = (0..i + 1).random()
            val allegiance = (0..1).random()
            val magicPoints = (0..1).random()
            val strength = (0..i + 1).random()
            val invoker: Battler = MockBattler(
                actions, agility, allegiance, magicPoints, strength, UUID.randomUUID(),
            )
            invokers.add(invoker)
        }
        val battle = Battle<Battler>(
            invokers, uuid = UUID.randomUUID()
        )
        battle.tick().forEach { tracer ->
            println(tracer)
        }
    }
}