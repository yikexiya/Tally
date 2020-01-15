package com.yikexiya.tally.ui.home.model

import com.yikexiya.tally.data.RecordType

class Record(
    val isExpense: Boolean,
    val type: RecordType,
    val money: Float,
    val timestamp: Long,
    val remark: String = ""
) {
    fun getIconRes() {}

    fun getTypeName(): String {
        return ""
    }
}