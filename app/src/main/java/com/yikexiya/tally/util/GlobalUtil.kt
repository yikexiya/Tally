package com.yikexiya.tally.util

import android.widget.Toast
import com.yikexiya.tally.app.TallyApplication

fun toast(message: String) {
    Toast.makeText(TallyApplication.instance(), message, Toast.LENGTH_SHORT).show()
}

fun toast(res: Int) {
    Toast.makeText(TallyApplication.instance(), res, Toast.LENGTH_SHORT).show()
}