package com.yikexiya.tally.ui.recordtype

import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.findNavController
import com.yikexiya.tally.app.TallyApplication

class RecordTypeViewModel : AndroidViewModel(TallyApplication.instance()) {
    var isExpense = false
    fun directionToSaveRecordType(view: View) {
        val directions = RecordTypeFragmentDirections.actionRecordTypeFragmentToSaveRecordTypeFragment(isExpense)
        view.findNavController().navigate(directions)
    }
}