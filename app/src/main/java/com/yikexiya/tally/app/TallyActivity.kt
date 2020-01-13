package com.yikexiya.tally.app

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.yikexiya.tally.R


class TallyActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var toolbar: Toolbar
    private val toolbarColor = R.color.colorPrimaryDark

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tally)
        navController = findNavController(R.id.nav_host)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

//        setToolBarColor(toolbarColor)
        initToolbar()
    }

    private fun initToolbar() {
        val decorView = window.decorView
        val option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        decorView.systemUiVisibility = option
        window.statusBarColor = Color.TRANSPARENT
        actionBar?.hide()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    private fun setToolBarColor(@ColorRes resId: Int) {
        val color = resources.getColor(resId, theme)
        window.statusBarColor = color
        val red = color and 0xff0000 shr 16
        val green = color and 0xff00 shr 8
        val blue = color and 0xff
        val lightColor = red * 0.299 + green * 0.578 + blue * 0.114 >= 192
        setToolbarMode(lightColor)
    }

    // 原生系统api设置状态栏文字颜色
    private fun setToolbarMode(lightMode: Boolean) {
        setLightToolbar(window, lightMode, toolbarColor)
    }

    private fun setLightToolbar(window: Window, lightMode: Boolean, @ColorRes color: Int) {
        val decorView = window.decorView
        var originVisibility = decorView.systemUiVisibility
        // 亮色模式，使用黑色文字
        if (lightMode && (originVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) == 0) {
            originVisibility = originVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        if (!lightMode && (originVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) != 0) {
            originVisibility = originVisibility xor View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        decorView.systemUiVisibility = originVisibility
        window.statusBarColor = resources.getColor(color, theme)
    }
}
