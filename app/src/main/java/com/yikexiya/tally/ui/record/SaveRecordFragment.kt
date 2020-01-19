package com.yikexiya.tally.ui.record

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.yikexiya.tally.R
import com.yikexiya.tally.databinding.FragmentSaveRecordBinding
import com.yikexiya.tally.ui.record.model.RecordTypeDisplayModel

class SaveRecordFragment : Fragment() {
    private lateinit var binding: FragmentSaveRecordBinding
    private lateinit var viewPage: ViewPager2
    private lateinit var tabLayout: TabLayout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSaveRecordBinding.inflate(inflater, container, false)
        tabLayout = binding.tab
        viewPage = binding.viewPager
        tabLayout.addTab(tabLayout.newTab().setText(R.string.expense))
        tabLayout.addTab(tabLayout.newTab().setText(R.string.earning))
        return binding.root
    }
    
    companion object {
        private val expenseList = listOf(
            RecordTypeDisplayModel(R.drawable.ic_cart, "购物", "1"),
            RecordTypeDisplayModel(R.drawable.ic_cart, "购物", "2"),
            RecordTypeDisplayModel(R.drawable.ic_cart, "购物", "3"),
            RecordTypeDisplayModel(R.drawable.ic_cart, "购物", "4"),
            RecordTypeDisplayModel(R.drawable.ic_cart, "购物", "5"),
            RecordTypeDisplayModel(R.drawable.ic_cart, "购物", "6"),
            RecordTypeDisplayModel(R.drawable.ic_cart, "购物", "7"),
            RecordTypeDisplayModel(R.drawable.ic_cart, "购物", "8")
        )
        private val earningList = listOf(
            RecordTypeDisplayModel(R.drawable.ic_cart, "购物", "1"),
            RecordTypeDisplayModel(R.drawable.ic_cart, "购物", "2"),
            RecordTypeDisplayModel(R.drawable.ic_cart, "购物", "3"),
            RecordTypeDisplayModel(R.drawable.ic_cart, "购物", "4"),
            RecordTypeDisplayModel(R.drawable.ic_cart, "购物", "5"),
            RecordTypeDisplayModel(R.drawable.ic_cart, "购物", "6"),
            RecordTypeDisplayModel(R.drawable.ic_cart, "购物", "7")
        )
    }
}