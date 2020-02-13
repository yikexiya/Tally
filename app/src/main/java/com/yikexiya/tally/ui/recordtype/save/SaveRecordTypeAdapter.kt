package com.yikexiya.tally.ui.recordtype.save

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yikexiya.tally.databinding.ItemSaveRecordTypeBinding

class SaveRecordTypeAdapter(
    private val viewModel: SaveRecordTypeViewModel,
    private val isExpense: Boolean
) :
    ListAdapter<Int, SaveRecordTypeAdapter.ViewHolder>(object :
        DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }
    }) {
    inner class ViewHolder(private val binding: ItemSaveRecordTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(iconRes: Int) {
            binding.vm = viewModel
            binding.iconRes = iconRes
            binding.isExpense = isExpense
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemSaveRecordTypeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}