package com.yikexiya.tally.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.yikexiya.tally.databinding.ItemHomeDayExpenseBinding
import com.yikexiya.tally.databinding.ItemHomeExpenseTypeBinding
import com.yikexiya.tally.databinding.ItemHomeMonthExpenseBinding
import com.yikexiya.tally.ui.home.model.Record

class HomeAdapter(context: Context, private val viewModel: HomeViewModel) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater = LayoutInflater.from(context)
    private val dataList = mutableListOf<Record>()
    // 0表示当月收入信息，1表示当日收入信息，其他表示记录列表
    override fun getItemViewType(position: Int): Int {
        return position.coerceAtMost(2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> {
                val binding = ItemHomeMonthExpenseBinding.inflate(inflater, parent, false)
                MonthRecordViewHolder(binding)
            }
            1 -> {
                val binding = ItemHomeDayExpenseBinding.inflate(inflater, parent, false)
                DayRecordViewHolder(binding)
            }
            else -> {
                val binding = ItemHomeExpenseTypeBinding.inflate(inflater, parent, false)
                ExpenseTypeViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size + 2
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MonthRecordViewHolder -> holder.bind()
            is DayRecordViewHolder -> holder.bind()
            is ExpenseTypeViewHolder -> holder.bind(dataList[position - 2])
        }
    }

    fun resetData(list: List<Record>) {
        val result = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return false
            }

            override fun getOldListSize(): Int {
                return dataList.size + 2
            }

            override fun getNewListSize(): Int {
                return list.size + 2
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return false
            }
        })
        dataList.clear()
        dataList.addAll(list)
        result.dispatchUpdatesTo(this)
    }

    inner class MonthRecordViewHolder(private val binding: ItemHomeMonthExpenseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.vm = viewModel
            binding.executePendingBindings()
        }
    }

    inner class DayRecordViewHolder(private val binding: ItemHomeDayExpenseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.vm = viewModel
            binding.executePendingBindings()
        }
    }

    inner class ExpenseTypeViewHolder(private val binding: ItemHomeExpenseTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(record: Record) {
            binding.model = record
            binding.executePendingBindings()
        }
    }
}