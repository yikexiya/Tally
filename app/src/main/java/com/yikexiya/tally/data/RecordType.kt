package com.yikexiya.tally.data

import java.util.*

class RecordType(
    val isExpense: Boolean,
    val icon: Int,
    val name: String,
    val id: String = UUID.randomUUID().toString()
)