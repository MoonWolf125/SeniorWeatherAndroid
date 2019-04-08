package com.project.dahnky.seniorweatherandroid.view.nav.info

import com.project.dahnky.seniorweatherandroid.core.ICoreView
import com.project.dahnky.seniorweatherandroid.model.ResourceInformation

interface IInfoView : ICoreView {
    fun setResources(resources: List<ResourceInformation>)
}
