package com.yikexiya.tally.ui.home.model

data class RecordDisplayModel(
    val isExpense: Boolean,
    val iconRes: Int,
    val typeName: String,
    val money: String,
    val time: String,
    val id: String,
    val remark: String = ""
)