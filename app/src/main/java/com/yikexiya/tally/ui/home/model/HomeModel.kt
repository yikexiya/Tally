package com.yikexiya.tally.ui.home.model

interface HomeModel {
    fun getItemType(): Int
    companion object {
        const val MONTH_EXPENSE = 0
        const val DAY_EXPENSE = 1
        const val EXPENSE_TYPE = 2
    }
}