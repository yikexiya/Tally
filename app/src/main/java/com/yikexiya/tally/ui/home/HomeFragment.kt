package com.yikexiya.tally.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.yikexiya.tally.R
import com.yikexiya.tally.databinding.FragmentHomeBinding
import com.yikexiya.tally.util.toast

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_home, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_debug -> toast("导出数据库文件")
            R.id.menu_search -> toast("搜索")
        }
        return super.onOptionsItemSelected(item)
    }
}