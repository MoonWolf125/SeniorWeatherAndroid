package com.project.dahnky.sacweather.view.custom.drawer

interface DrawerViewListener {
    enum class DrawerSelection {
        HOME,
        EMBEDDED,
        INFO
    }

    fun onDrawerNavClick(drawerSelection: DrawerSelection)

    fun setToolbarTitle(title: String)
}
