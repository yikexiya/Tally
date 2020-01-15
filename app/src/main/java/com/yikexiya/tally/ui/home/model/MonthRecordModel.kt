package com.yikexiya.tally.ui.home.model

class MonthRecordModel(
    private val _expense: Float,
    private val _earning: Float,
    private val _budget: Float
) : HomeModel {

    fun getExpense(): String {
        return "￥${String.format("%.2f", _expense)}"
    }
    fun getEarning(): String {
        return "￥${String.format("%.2f", _earning)}"
    }

    fun getBudget(): String {
        return "￥${String.format("%.2f", _budget)}"
    }

    override fun getItemType(): Int {
        return HomeModel.MONTH_EXPENSE
    }
}