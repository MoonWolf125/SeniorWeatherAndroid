package com.project.dahnky.sacweather.view.nav.info

import android.content.res.AssetManager
import com.google.gson.Gson
import com.project.dahnky.sacweather.core.CorePresenter
import com.project.dahnky.sacweather.model.ResourceInformationList
import com.project.dahnky.sacweather.service.ResourcesEvent
import com.project.dahnky.sacweather.view.custom.resource.ResourceRowListener
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject

class InfoPresenter @Inject constructor(val view: IInfoView) : CorePresenter(), ResourceRowListener {

    private lateinit var resourceInformation: ResourceInformationList

    fun start(assets: AssetManager) {
        getResourceInformation(assets = assets)
        view.setResources(resourceInformation.resources)
    }

    override fun finish() {
        // service.cancelCall()
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    fun onEventReceived(event: ResourcesEvent) {
        EventBus.getDefault().removeStickyEvent(event::class.java)
//        view.setResources(event.resources)
    }

    override fun onOpenResourceLink(link: String): Boolean {
        view.openResourceLink(link)
        return true
    }

    private fun getResourceInformation(assets: AssetManager) {
        val input: InputStream
        val size: Int
        val buffer: ByteArray
        var json = ""
        try {
            input = assets.open("project_resources.json")
            size = input.available()
            buffer = ByteArray(size)
            input.read(buffer)
            input.close()
            json = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        val gson = Gson()
        resourceInformation = gson.fromJson(json, ResourceInformationList::class.java)
    }
}