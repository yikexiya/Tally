package com.yikexiya.tally.ui.home

import android.preference.PreferenceManager
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yikexiya.tally.R
import com.yikexiya.tally.app.TallyApplication
import com.yikexiya.tally.data.RecordType
import com.yikexiya.tally.ui.home.model.Record
import com.yikexiya.tally.ui.home.model.RecordDisplayModel
import com.yikexiya.tally.util.toast
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.exp

class HomeViewModel : AndroidViewModel(TallyApplication.instance()) {
    private var budget: Float
    val monthExpense: ObservableField<String> = ObservableField()
    val monthEarning: ObservableField<String> = ObservableField()
    val monthBudget: ObservableField<String> = ObservableField()
    val todayExpense: ObservableField<String> = ObservableField()
    val todayEarning: ObservableField<String> = ObservableField()
    val moneyVisible = ObservableBoolean(true)

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _recordList = MutableLiveData<List<RecordDisplayModel>>()
    val recordList: LiveData<List<RecordDisplayModel>> = _recordList

    private val mockType = RecordType(true, R.drawable.ic_cart, "购物")

    private val originData = listOf(
        Record(mockType, Random().nextFloat()*100, System.currentTimeMillis()),
        Record(mockType, Random().nextFloat()*100, System.currentTimeMillis()),
        Record(mockType, Random().nextFloat()*100, System.currentTimeMillis()),
        Record(mockType, Random().nextFloat()*100, System.currentTimeMillis()),
        Record(mockType, Random().nextFloat()*100, System.currentTimeMillis()),
        Record(mockType, Random().nextFloat()*100, System.currentTimeMillis())
    )

    init {
        val preferences = PreferenceManager.getDefaultSharedPreferences(getApplication())
        budget = preferences.getFloat("budget", 0f)
        refresh()
    }

    fun onMonthExpenseClick(view: View) {
        toast("跳转界面")
//        view.findNavController()
    }

    fun onEyeClick() {}
    fun showOrHideMoney(show: Boolean) {}
    fun refresh() {
        _loading.value = true
        var expense = 0f
        var earning = 0f
        val data = originData.map {
            val qian = it.money + Random().nextInt(20)
            if (it.type.isExpense) {
                expense += qian
            } else {
                earning += qian
            }
            val money = "￥${String.format("%.2f", qian)}"
            val time = formatTime(it.timestamp)
            RecordDisplayModel(it.type.isExpense, it.type.icon, it.type.name, money, time, it.id, it.remark)
        }
        todayExpense.set("￥${String.format("%.2f", expense)}")
        todayEarning.set("￥${String.format("%.2f", earning)}")
        _recordList.value = data
        _loading.value = false
    }
    private fun formatTime(timestamp: Long): String {
        val date = Date(timestamp)
        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        return "今天 ${sdf.format(date)}"
    }
}