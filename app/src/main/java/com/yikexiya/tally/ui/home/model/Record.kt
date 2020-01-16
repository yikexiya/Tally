package com.yikexiya.tally.ui.home.model

import com.yikexiya.tally.data.RecordType
import java.util.*

class Record(
    val type: RecordType,
    val money: Float,
    val timestamp: Long,
    val remark: String = "",
    val id: String = UUID.randomUUID().toString()
)