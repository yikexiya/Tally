package com.yikexiya.tally.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.yikexiya.tally.R
import com.yikexiya.tally.app.ViewModelFactory
import com.yikexiya.tally.databinding.FragmentHomeBinding
import com.yikexiya.tally.util.toast

class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels {
        ViewModelFactory()
    }
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: HomeAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        binding.refreshLayout.setOnRefreshListener { refreshLayout ->
            refreshLayout.finishRefresh(1000)
        }
        binding.refreshLayout.setOnLoadMoreListener { refreshLayout ->
            refreshLayout.finishLoadMore(1000)
        }
        adapter = HomeAdapter(requireContext(), viewModel)
        binding.tallyList.adapter = adapter
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.recordList.observe(viewLifecycleOwner) {
            adapter.resetData(it)
        }
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