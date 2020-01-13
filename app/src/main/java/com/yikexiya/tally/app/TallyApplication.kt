package com.yikexiya.tally.app

import android.app.Application
import kotlin.properties.Delegates

class TallyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
    companion object {
        private var instance: TallyApplication by Delegates.notNull()
        fun instance() = instance
    }
}