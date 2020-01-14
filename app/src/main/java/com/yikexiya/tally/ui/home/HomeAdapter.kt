package com.yikexiya.tally.ui.home

import com.chad.library.adapter.base.BaseProviderMultiAdapter
import com.yikexiya.tally.app.MultiItemType

class HomeAdapter : BaseProviderMultiAdapter<MultiItemType>() {
    override fun getItemType(data: List<MultiItemType>, position: Int): Int {
        val type = data[position].getItemType()
        when (type) {

        }
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}