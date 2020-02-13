package com.yikexiya.tally.ui.recordtype.save

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.yikexiya.tally.app.TallyApplication
import com.yikexiya.tally.data.RecordType

class SaveRecordTypeViewModel : AndroidViewModel(TallyApplication.instance()) {
    val currentRecordType: ObservableField<RecordType> = ObservableField()
    fun saveRecordType(view: View) {

    }
}