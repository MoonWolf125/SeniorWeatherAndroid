package com.project.dahnky.sacweather.view.nav.info

import com.project.dahnky.sacweather.core.ICoreView
import com.project.dahnky.sacweather.model.ResourceInformation

interface IInfoView : ICoreView {
    fun setResources(resources: List<ResourceInformation>)
    fun openResourceLink(link: String)
}
