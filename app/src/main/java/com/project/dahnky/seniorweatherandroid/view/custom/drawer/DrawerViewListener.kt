package com.project.dahnky.seniorweatherandroid.view.custom.drawer

interface DrawerViewListener {
    enum class DrawerSelection {
        HOME,
        EMBEDDED,
        INFO
    }

    fun onDrawerNavClick(drawerSelection: DrawerSelection)
}
