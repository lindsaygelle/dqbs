package com.github.lindsaygelle.dqbs

import java.util.*

open class MagicAbility<I : MagicInvoker, R : Receiver>(
    limit: Int,
    override var magicPoints: Int,
    uuid: UUID,
) : Ability<I, R>(limit, uuid),
    MagicPointer