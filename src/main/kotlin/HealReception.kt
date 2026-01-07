import com.github.lindsaygelle.HitPointer
import com.github.lindsaygelle.Reception
import java.util.*

class HealReception(hitPoints: Int, timeMillisecond: Long, uuid: UUID) : Reception(timeMillisecond, uuid),
    HitPointer {
    override var hitPoints: Int = hitPoints
        set(value) {
            field = value
            logger.trace("hitPoints={}", field)
        }

    init {
        this.hitPoints = hitPoints
    }

    override fun toString(): String {
        return "hitPoints=${hitPoints} ${super.toString()}}"
    }
}