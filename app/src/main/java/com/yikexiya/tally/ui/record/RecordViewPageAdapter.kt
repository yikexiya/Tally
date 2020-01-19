package com.yikexiya.tally.ui.record

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yikexiya.tally.databinding.FragmentRecordTypeListBinding

class RecordViewPageAdapter :
    RecyclerView.Adapter<RecordViewPageAdapter.ViewPagerAdapter>() {
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
    }

    inner class ViewPagerAdapter(private val binding: FragmentRecordTypeListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.typeList.layoutManager = GridLayoutManager(binding.root.context, 5)
        }
    }
}