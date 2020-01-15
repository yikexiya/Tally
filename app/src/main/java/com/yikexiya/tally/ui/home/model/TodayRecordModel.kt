package com.yikexiya.tally.ui.home.model

class TodayRecordModel(private val _expense: Float, private val _earning: Float): HomeModel {
    fun getExpense(): String {
        return "￥${String.format("%.2f", _expense)}"
    }
    fun getEarning(): String {
        return "￥${String.format("%.2f", _earning)}"
    }

    override fun getItemType(): Int {
        return HomeModel.DAY_EXPENSE
    }
}