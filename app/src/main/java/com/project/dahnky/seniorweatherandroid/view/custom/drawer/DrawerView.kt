package com.project.dahnky.seniorweatherandroid.view.custom.drawer

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.FrameLayout
import com.project.dahnky.seniorweatherandroid.R
import kotlinx.android.synthetic.main.view_drawer.view.*

class DrawerView @JvmOverloads constructor(context: Context,
                                           attrs: AttributeSet? = null,
                                           defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {
    init {
        if (attrs == null) {
            layoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        }
        inflate(context, R.layout.view_drawer, this)
    }

    fun setup(listener: DrawerViewListener) {
        container_home.setOnClickListener { listener.onDrawerNavClick("home") }
        container_embedded.setOnClickListener { listener.onDrawerNavClick("embedded") }
        container_info.setOnClickListener { listener.onDrawerNavClick("info") }
    }
}