package com.yikexiya.tally.ui.recordtype

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yikexiya.tally.databinding.FragmentRecordTypeBinding

class RecordTypeFragment : Fragment() {
    private lateinit var binding: FragmentRecordTypeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecordTypeBinding.inflate(inflater, container, false)
        return binding.root
    }
}