package com.yikexiya.tally.ui.record

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.yikexiya.tally.R
import com.yikexiya.tally.data.RecordType
import com.yikexiya.tally.databinding.FragmentSaveRecordBinding

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
        viewPage.adapter = RecordViewPageAdapter(expenseList, earningList)
        TabLayoutMediator(tabLayout, viewPage) { tab, position ->
            tab.text = if (position == 0)
                getString(R.string.expense)
            else
                getString(R.string.earning)
        }.attach()
        return binding.root
    }
    
    companion object {
        private val expenseList = listOf(
            RecordType(true, R.drawable.ic_cart, "购物", "1"),
            RecordType(true, R.drawable.ic_cart, "购物", "2"),
            RecordType(true, R.drawable.ic_cart, "购物", "3"),
            RecordType(true, R.drawable.ic_cart, "购物", "4"),
            RecordType(true, R.drawable.ic_cart, "购物", "5"),
            RecordType(true, R.drawable.ic_cart, "购物", "6"),
            RecordType(true, R.drawable.ic_cart, "购物", "7"),
            RecordType(true, R.drawable.ic_cart, "购物", "8")
        )
        private val earningList = listOf(
            RecordType(true, R.drawable.ic_cart, "购物", "1"),
            RecordType(true, R.drawable.ic_cart, "购物", "2"),
            RecordType(true, R.drawable.ic_cart, "购物", "3"),
            RecordType(true, R.drawable.ic_cart, "购物", "4"),
            RecordType(true, R.drawable.ic_cart, "购物", "5"),
            RecordType(true, R.drawable.ic_cart, "购物", "6"),
            RecordType(true, R.drawable.ic_cart, "购物", "7")
        )
    }
}