package com.yikexiya.tally.ui.recordtype

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.yikexiya.tally.R
import com.yikexiya.tally.app.ViewModelFactory
import com.yikexiya.tally.databinding.FragmentRecordTypeBinding

class RecordTypeFragment : Fragment() {
    private val viewModel: RecordTypeViewModel by viewModels {
        ViewModelFactory()
    }
    private lateinit var binding: FragmentRecordTypeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecordTypeBinding.inflate(inflater, container, false)
        binding.vm = viewModel
        binding.viewPager.adapter = RecordTypeViewPageAdapter(viewModel, emptyList(), emptyList())
        TabLayoutMediator(binding.tab, binding.viewPager) { tab, position ->
            tab.text = if (position == 0)
                getString(R.string.expense)
            else
                getString(R.string.earning)
        }.attach()
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                viewModel.isExpense = position == 0
            }
        })
        return binding.root
    }
}