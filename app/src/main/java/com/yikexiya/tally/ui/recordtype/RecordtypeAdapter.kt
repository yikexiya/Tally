package com.yikexiya.tally.ui.recordtype

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yikexiya.tally.data.RecordType
import com.yikexiya.tally.databinding.ItemRecordtypeListBinding
import com.yikexiya.tally.ui.record.RecordTypeDiff

class RecordtypeAdapter : ListAdapter<RecordType, RecordtypeAdapter.ViewHolder>(RecordTypeDiff()) {
    inner class ViewHolder(private val binding: ItemRecordtypeListBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecordtypeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}