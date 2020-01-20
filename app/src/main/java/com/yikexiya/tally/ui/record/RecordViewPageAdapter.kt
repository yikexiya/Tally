package com.yikexiya.tally.ui.record

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yikexiya.tally.data.RecordType
import com.yikexiya.tally.databinding.FragmentRecordTypeListBinding

class RecordViewPageAdapter(private val expenseTypeList: List<RecordType>, private val earningTypeList: List<RecordType>) :
    RecyclerView.Adapter<RecordViewPageAdapter.ViewPagerAdapter>() {
    private val expenseAdapter: RecordTypeAdapter = RecordTypeAdapter()
    private val earningAdapter: RecordTypeAdapter = RecordTypeAdapter()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdapter {
        val binding = FragmentRecordTypeListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewPagerAdapter(binding)
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter, position: Int) {
        holder.bind(position == 0)
    }

    inner class ViewPagerAdapter(private val binding: FragmentRecordTypeListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(isExpense: Boolean) {
            if (isExpense) {
                binding.typeList.adapter = expenseAdapter
                expenseAdapter.submitList(expenseTypeList)
            } else {
                binding.typeList.adapter = earningAdapter
                earningAdapter.submitList(earningTypeList)
            }
            binding.typeList.layoutManager = GridLayoutManager(binding.root.context, 5)
        }
    }
}