package com.yikexiya.tally.ui.recordtype

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yikexiya.tally.data.RecordType
import com.yikexiya.tally.databinding.ItemRecordtypeTypeListBinding
import com.yikexiya.tally.ui.record.RecordTypeDiff

class RecordtypeAdapter(private val viewModel: RecordTypeViewModel) :
    ListAdapter<RecordType, RecordtypeAdapter.ViewHolder>(RecordTypeDiff()) {
    inner class ViewHolder(private val binding: ItemRecordtypeTypeListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recordType: RecordType) {
            binding.vm = viewModel
            binding.model = recordType
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecordtypeTypeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}