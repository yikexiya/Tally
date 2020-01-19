package com.yikexiya.tally.component

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDialog
import com.yikexiya.tally.R
import com.yikexiya.tally.databinding.DialogSetMonthBudgetBinding
import com.yikexiya.tally.util.toast

class SetBudgetDialog(context: Context, private val onSuccess: (Float) -> Unit): AppCompatDialog(context, R.style.Widget_Dialog_BottomSheet) {
    private lateinit var binding: DialogSetMonthBudgetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogSetMonthBudgetBinding.inflate(LayoutInflater.from(context), null, false)
        binding.budget.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
            }
        }
        binding.close.setOnClickListener {
            dismiss()
        }
        binding.sure.setOnClickListener {
            val budget = binding.budget.text.toString().toFloatOrNull()
            if (budget != null && budget > 0) {
                onSuccess.invoke(budget)
                dismiss()
            } else {
                toast(R.string.please_input_positive_int)
            }
        }
        setContentView(binding.root)
        initWindowHeight()
    }

    // 设置底部弹出框的高度
    private fun initWindowHeight() {
        binding.root.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        window?.run {
            setGravity(Gravity.BOTTOM)
            val attribute = this.attributes
            attribute.width = context.resources.displayMetrics.widthPixels
            attribute.height = binding.root.measuredHeight
            this.attributes = attributes
        }
    }

    override fun show() {
        super.show()
        binding.budget.requestFocus()
    }
}