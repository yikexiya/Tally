package com.yikexiya.tally.binding

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("selected", requireAll = false)
fun setSelected(view: View, selected: Boolean) {
    view.isSelected = selected
}
