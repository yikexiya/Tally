package com.yikexiya.tally.ui.home

import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.yikexiya.tally.R
import com.yikexiya.tally.app.MultiItemType
import com.yikexiya.tally.databinding.ItemHomeMonthExpenseBinding

class ItemHomeMonthExpenseProvider : BaseItemProvider<MultiItemType>() {
    override fun convert(helper: BaseViewHolder, data: MultiItemType?) {
        val binding = helper.getBinding<ItemHomeMonthExpenseBinding>()
    }

    override val itemViewType: Int
        get() = 0
    override val layoutId: Int
        get() = R.layout.item_home_month_expense

    override fun onViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        super.onViewHolderCreated(viewHolder, viewType)
    }
}