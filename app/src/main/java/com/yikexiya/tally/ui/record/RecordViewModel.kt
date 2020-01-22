package com.yikexiya.tally.ui.record

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.yikexiya.tally.R
import com.yikexiya.tally.app.TallyApplication
import com.yikexiya.tally.data.RecordType

class RecordViewModel : AndroidViewModel(TallyApplication.instance()) {
    val selectedItem: ObservableField<RecordType> = ObservableField()
    // 保存支出或收入记录时的金额
    val money = ObservableField<String>("￥0")
    fun onItemClick(recordType: RecordType) {
        selectedItem.set(recordType)
    }

    // 点击添加备注时跳出对话框
    fun onAddRemarkClick(view: View) {
        if (view is AppCompatTextView) {
            val context = view.context
        }
    }
}