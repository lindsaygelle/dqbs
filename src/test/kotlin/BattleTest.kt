import com.github.lindsaygelle.dqbs.Battle
import com.github.lindsaygelle.dqbs.Battler
import kotlin.test.Test

class BattleTest {
    @Test
    fun test() {
        val invokers = mutableListOf<Battler>()
        for (i in 1..10) {
            val invoker: Battler = MockBattler()
            invokers.add(invoker)
        }
        val battle = Battle(
            invokers
        )
        battle.tick().forEach { tracer ->
            println(tracer)
        }
    }
}