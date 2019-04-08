package com.project.dahnky.seniorweatherandroid.view.custom.resource

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.FrameLayout
import com.project.dahnky.seniorweatherandroid.R
import com.project.dahnky.seniorweatherandroid.model.ResourceInformation

class ResourceRowView @JvmOverloads constructor(context: Context,
                                                attrs: AttributeSet? = null,
                                                defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {
    init {
        if (attrs == null) {
            layoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }
        inflate(context, R.layout.view_drawer, this)
    }
    fun setup(
        get: ResourceInformation,
        listener: ResourceRowListener
    ) {
        // TODO
    }
}