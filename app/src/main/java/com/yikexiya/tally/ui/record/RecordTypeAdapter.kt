package com.yikexiya.tally.ui.record

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yikexiya.tally.data.RecordType

class RecordTypeAdapter : ListAdapter<RecordType, RecordTypeAdapter.ViewHolder>(RecordTypeDiff()) {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

private class RecordTypeDiff : DiffUtil.ItemCallback<RecordType>() {
    override fun areItemsTheSame(oldItem: RecordType, newItem: RecordType): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RecordType, newItem: RecordType): Boolean {
        return oldItem.isExpense == newItem.isExpense
                &&oldItem.icon == newItem.icon
                &&oldItem.name == newItem.name
    }

}