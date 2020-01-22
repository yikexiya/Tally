package com.yikexiya.tally.ui.recordtype

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yikexiya.tally.data.RecordType
import com.yikexiya.tally.databinding.ItemRecordtypeViewpageBinding

class RecordTypeViewPageAdapter(
    private val viewModel: RecordTypeViewModel,
    private val expenseTypeList: List<RecordType>,
    private val earningTypeList: List<RecordType>
) :
    RecyclerView.Adapter<RecordTypeViewPageAdapter.ViewPagerAdapter>() {
    private val expenseAdapter: RecordtypeAdapter = RecordtypeAdapter(viewModel)
    private val earningAdapter: RecordtypeAdapter = RecordtypeAdapter(viewModel)
    inner class ViewPagerAdapter(private val binding: ItemRecordtypeViewpageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(isExpense: Boolean) {
            if (isExpense) {
                binding.recordTypeList.adapter = expenseAdapter
                expenseAdapter.submitList(expenseTypeList)
            } else {
                binding.recordTypeList.adapter = earningAdapter
                earningAdapter.submitList(earningTypeList)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdapter {
        val binding = ItemRecordtypeViewpageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewPagerAdapter(binding)
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter, position: Int) {
        holder.bind(position == 0)
    }
}