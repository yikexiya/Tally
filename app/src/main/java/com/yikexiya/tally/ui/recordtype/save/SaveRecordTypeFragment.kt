package com.yikexiya.tally.ui.recordtype.save

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.yikexiya.tally.R
import com.yikexiya.tally.app.ViewModelFactory
import com.yikexiya.tally.databinding.FragmentSaveRecordTypeBinding

class SaveRecordTypeFragment : Fragment() {
    private val args: SaveRecordTypeFragmentArgs by navArgs()
    private val viewModel by viewModels<SaveRecordTypeViewModel> {
        ViewModelFactory()
    }
    private lateinit var binding: FragmentSaveRecordTypeBinding
    private lateinit var adapter: SaveRecordTypeAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSaveRecordTypeBinding.inflate(inflater, container, false)
        binding.vm = viewModel
        adapter = SaveRecordTypeAdapter(viewModel, args.isExpense)
        adapter.submitList(listOf(
            R.drawable.ic_cart,
            R.drawable.ic_cart,
            R.drawable.ic_cart,
            R.drawable.ic_cart,
            R.drawable.ic_cart,
            R.drawable.ic_cart,
            R.drawable.ic_cart,
            R.drawable.ic_cart
        ))
        binding.iconList.adapter = adapter
        return binding.root
    }
}