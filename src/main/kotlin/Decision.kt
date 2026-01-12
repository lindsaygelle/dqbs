package com.github.lindsaygelle

import java.util.*

class Decision(assessments: List<Assessment>, result: Boolean, timeMilliseconds: Long, uuid: UUID) : Consideration(
    assessments, result, timeMilliseconds, uuid
)