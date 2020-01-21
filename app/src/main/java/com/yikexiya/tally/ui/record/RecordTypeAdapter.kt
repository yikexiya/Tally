package com.yikexiya.tally.ui.record

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yikexiya.tally.data.RecordType
import com.yikexiya.tally.databinding.ItemRecordTypeBinding

class RecordTypeAdapter(private val viewModel: RecordViewModel) :
    ListAdapter<RecordType, RecordTypeAdapter.ViewHolder>(RecordTypeDiff()) {
    inner class ViewHolder(private val binding: ItemRecordTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recordType: RecordType) {
            binding.model = recordType
            binding.vm = viewModel
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemRecordTypeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recordType = getItem(position)
        holder.bind(recordType)
    }
}

private class RecordTypeDiff : DiffUtil.ItemCallback<RecordType>() {
    override fun areItemsTheSame(oldItem: RecordType, newItem: RecordType): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RecordType, newItem: RecordType): Boolean {
        return oldItem.isExpense == newItem.isExpense
                && oldItem.icon == newItem.icon
                && oldItem.name == newItem.name
    }

}