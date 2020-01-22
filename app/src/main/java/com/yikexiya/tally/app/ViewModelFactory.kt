package com.yikexiya.tally.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yikexiya.tally.ui.home.HomeViewModel
import com.yikexiya.tally.ui.record.RecordViewModel
import com.yikexiya.tally.ui.recordtype.RecordTypeViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return with(modelClass) {
            when {
                isAssignableFrom(HomeViewModel::class.java) ->
                    HomeViewModel()
                isAssignableFrom(RecordViewModel::class.java) ->
                    RecordViewModel()
                isAssignableFrom(RecordTypeViewModel::class.java) ->
                    RecordTypeViewModel()
                else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
    }
}