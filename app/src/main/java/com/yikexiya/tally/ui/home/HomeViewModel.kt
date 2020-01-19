package com.yikexiya.tally.ui.home

import android.preference.PreferenceManager
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.yikexiya.tally.R
import com.yikexiya.tally.app.TallyApplication
import com.yikexiya.tally.component.SetBudgetDialog
import com.yikexiya.tally.data.RecordType
import com.yikexiya.tally.ui.home.model.Record
import com.yikexiya.tally.ui.home.model.RecordDisplayModel
import com.yikexiya.tally.util.toast
import java.text.SimpleDateFormat
import java.util.*

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
        Record(mockType, Random().nextFloat() * 100, Date(120, 0, 3).time),
        Record(mockType, Random().nextFloat() * 100, Date(120, 3, 24).time),
        Record(mockType, Random().nextFloat() * 100, Date(120, 0, 13).time),
        Record(mockType, Random().nextFloat() * 100, Date(120, 6, 21).time),
        Record(mockType, Random().nextFloat() * 100, Date(120, 0, 22).time),
        Record(mockType, Random().nextFloat() * 100, Date(120, 3, 11).time)
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

    fun onExpenseTypeItemClick(view: View) {
        toast("跳转界面2")
    }

    // 点击添加一笔账单时触发
    fun onAddClick(view: View) {
        val directions = HomeFragmentDirections.actionHomeFragmentToSaveRecordFragment()
        view.findNavController().navigate(directions)
    }

    // 点击底部菜单时弹出底部对话框
    fun onListClick(view: View) {
//        val dialog = BottomSheetDialog(view.context)
    }

    // 点击剩余预算时底部弹出对话框
    fun onRemainBudgetClick(view: View) {
        SetBudgetDialog(view.context) {
            budget = it
            val money = monthExpense.get()?.trim('￥')?.toFloatOrNull() ?: 0f
            monthBudget.set("￥${String.format("%.2f", budget - money)}")
            PreferenceManager.getDefaultSharedPreferences(getApplication())
                .edit()
                .putFloat("budget", it)
                .apply()
        }.show()
    }

    fun setAppBudget(budget: Float) {}

    fun onEyeClick() {}
    fun showOrHideMoney(show: Boolean) {
    }
    fun refresh() {
        _loading.value = true
        val today = Calendar.getInstance()
        var mExpense = 0f
        var mEarning = 0f
        var dExpense = 0f
        var dEarning = 0f
        val recordDisplayModelList = mutableListOf<RecordDisplayModel>()
        for (originDatum in originData) {
            // 统计当月的收支
            val qian = originDatum.money + Random().nextInt(20)
            if (originDatum.type.isExpense) {
                mExpense += qian
            } else {
                mEarning += qian
            }
            // 计算当天的收支
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = originDatum.timestamp
            if (today.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) && today.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)) {
                if (originDatum.type.isExpense) {
                    dExpense += qian
                } else {
                    dEarning += qian
                }
                val money = "￥${String.format("%.2f", qian)}"
                val time = formatTime(originDatum.timestamp)
                val record = RecordDisplayModel(
                    originDatum.type.isExpense,
                    originDatum.type.icon,
                    originDatum.type.name,
                    money,
                    time,
                    originDatum.id,
                    originDatum.remark
                )
                recordDisplayModelList.add(record)
            }
        }
        monthExpense.set("￥${String.format("%.2f", mExpense)}")
        monthEarning.set("￥${String.format("%.2f", mEarning)}")
        val mBudget = if (budget <= 0f) getApplication<TallyApplication>().getString(R.string.tap_to_set_budget) else "￥${String.format("%.2f", budget - mExpense)}"
        monthBudget.set(mBudget)
        todayExpense.set("￥${String.format("%.2f", dExpense)}")
        todayEarning.set("￥${String.format("%.2f", dEarning)}")
        _recordList.value = recordDisplayModelList
        _loading.value = false
    }

    private fun formatTime(timestamp: Long): String {
        val date = Date(timestamp)
        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        return "今天 ${sdf.format(date)}"
    }
}