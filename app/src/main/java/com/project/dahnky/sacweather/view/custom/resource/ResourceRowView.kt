package com.project.dahnky.sacweather.view.custom.resource

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.FrameLayout
import com.project.dahnky.sacweather.R
import com.project.dahnky.sacweather.model.ResourceInformation
import kotlinx.android.synthetic.main.view_resource_row.view.*

class ResourceRowView @JvmOverloads constructor(context: Context,
                                                attrs: AttributeSet? = null,
                                                defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {
    init {
        if (attrs == null) {
            layoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }
        inflate(context, R.layout.view_resource_row, this)
    }
    fun setup(resource: ResourceInformation, listener: ResourceRowListener) {
        tv_title.text = resource.title
        tv_description.text = resource.description

        setOnLongClickListener {
            listener.onOpenResourceLink(resource.link)
        }
    }
}