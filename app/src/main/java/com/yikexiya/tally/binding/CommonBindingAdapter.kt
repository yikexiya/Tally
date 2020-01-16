package com.yikexiya.tally.binding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("selected", requireAll = false)
fun setSelected(view: View, selected: Boolean) {
    view.isSelected = selected
}

@BindingAdapter("itemIcon", requireAll = false)
fun bindItemIcon(image: ImageView, iconRes: Int) {
    image.setImageResource(iconRes)
}
