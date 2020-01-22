package com.yikexiya.tally.ui.record

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.yikexiya.tally.R
import com.yikexiya.tally.app.ViewModelFactory
import com.yikexiya.tally.data.RecordType
import com.yikexiya.tally.databinding.FragmentSaveRecordBinding
import java.text.SimpleDateFormat
import java.util.*

class SaveRecordFragment : Fragment() {
    private val args by navArgs<SaveRecordFragmentArgs>()
    private val viewModel: RecordViewModel by viewModels {
        ViewModelFactory()
    }
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
        viewPage.adapter = RecordViewPageAdapter(viewModel, expenseList, earningList)
        viewPage.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position == 0) {
                    viewModel.selectedItem.set(expenseList[0])
                } else {
                    viewModel.selectedItem.set(earningList[0])
                }
            }
        })
        TabLayoutMediator(tabLayout, viewPage) { tab, position ->
            tab.text = if (position == 0)
                getString(R.string.expense)
            else
                getString(R.string.earning)
        }.attach()
        binding.time.text = getCurrentTime()
        binding.remark.text = getString(R.string.add_remark)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_save_record, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_config -> {
                val directions = SaveRecordFragmentDirections.actionSaveRecordFragmentToRecordTypeFragment()
                findNavController().navigate(directions)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getCurrentTime(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
        return sdf.format(Calendar.getInstance().time)
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
            RecordType(false, R.drawable.ic_cart, "购物", "9"),
            RecordType(false, R.drawable.ic_cart, "购物", "10"),
            RecordType(false, R.drawable.ic_cart, "购物", "11"),
            RecordType(false, R.drawable.ic_cart, "购物", "12"),
            RecordType(false, R.drawable.ic_cart, "购物", "14"),
            RecordType(false, R.drawable.ic_cart, "购物", "13"),
            RecordType(false, R.drawable.ic_cart, "购物", "15")
        )
    }
}