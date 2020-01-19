package com.yikexiya.tally.ui.record

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.yikexiya.tally.databinding.FragmentRecordTypeListBinding

class RecordTypeListFragment : Fragment() {
    private lateinit var binding: FragmentRecordTypeListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecordTypeListBinding.inflate(inflater, container, false)
        binding.typeList.layoutManager = GridLayoutManager(requireContext(), 5)
        return binding.root
    }
}