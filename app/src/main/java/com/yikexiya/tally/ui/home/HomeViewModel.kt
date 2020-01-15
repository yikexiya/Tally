package com.yikexiya.tally.ui.home

import android.preference.PreferenceManager
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yikexiya.tally.app.TallyApplication
import com.yikexiya.tally.data.RecordType
import com.yikexiya.tally.ui.home.model.Record
import com.yikexiya.tally.util.toast

class HomeViewModel : AndroidViewModel(TallyApplication.instance()) {
    private var budget: Float
    val monthExpense: ObservableField<String> = ObservableField()
    val monthEarning: ObservableField<String> = ObservableField()
    val monthBudget: ObservableField<String> = ObservableField()
    val todayExpense: ObservableField<String> = ObservableField()
    val todayEarning: ObservableField<String> = ObservableField()
    val moneyVisible = ObservableBoolean(true)

    private val _recordList = MutableLiveData<List<Record>>()
    val recordList: LiveData<List<Record>> = _recordList

    init {
        val preferences = PreferenceManager.getDefaultSharedPreferences(getApplication())
        budget = preferences.getFloat("budget", 0f)
        _recordList.value = listOf(
            Record(true, RecordType.SHOPPING, 20f, 200),
            Record(true, RecordType.SHOPPING, 40f, 200),
            Record(false, RecordType.SHOPPING, 130f, 200),
            Record(false, RecordType.SHOPPING, 254f, 200),
            Record(true, RecordType.SHOPPING, 112f, 200),
            Record(false, RecordType.SHOPPING, 73f, 200)
        )
    }

    fun onMonthExpenseClick(view: View) {
        toast("跳转界面")
//        view.findNavController()
    }

    fun onEyeClick() {}
    fun showOrHideMoney(show: Boolean) {}
    fun refresh() {}
}