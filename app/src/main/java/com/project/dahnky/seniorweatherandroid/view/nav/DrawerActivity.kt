package com.project.dahnky.seniorweatherandroid.view.nav

import android.os.Bundle
import android.widget.Toast
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.project.dahnky.seniorweatherandroid.core.BaseActivity
import com.project.dahnky.seniorweatherandroid.view.custom.drawer.DrawerView
import com.project.dahnky.seniorweatherandroid.view.custom.drawer.DrawerViewListener
import com.project.dahnky.seniorweatherandroid.view.nav.home.HomeFragment
import com.project.dahnky.seniorweatherandroid.view.nav.info.InfoFragment
import kotlinx.android.synthetic.main.toolbar.*
import com.project.dahnky.seniorweatherandroid.R

class DrawerActivity : BaseActivity(), DrawerViewListener {

    private lateinit var drawer: Drawer
    private lateinit var drawerSelection: DrawerViewListener.DrawerSelection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        startFragment(R.id.frame_container,
            HomeFragment.newInstance(), false)
        this.drawerSelection = DrawerViewListener.DrawerSelection.HOME
        setupDrawer(savedInstanceState)
    }

    override fun onDrawerNavClick(drawerSelection: DrawerViewListener.DrawerSelection) {
        if (drawerSelection != this.drawerSelection) {
            this.drawerSelection = drawerSelection
            when (drawerSelection) {
                DrawerViewListener.DrawerSelection.HOME -> startFragment(R.id.frame_container, HomeFragment.newInstance(), false)
                DrawerViewListener.DrawerSelection.EMBEDDED -> Toast.makeText(this, "Embedded", Toast.LENGTH_LONG).show()
                DrawerViewListener.DrawerSelection.INFO -> startFragment(R.id.frame_container, InfoFragment.newInstance(), false)
            }
            drawer.closeDrawer()
        }
    }

    private fun setupDrawer(savedInstanceState: Bundle?) {
        val drawerView = DrawerView(this)
        drawerView.setup(this)

        // Using the MaterialDrawer Library create the drawer
        drawer = DrawerBuilder(this)
            .withRootView(R.id.drawer_container)
            .withCustomView(drawerView)
            .withToolbar(toolbar)
            .withActionBarDrawerToggleAnimated(true)
            .withSavedInstance(savedInstanceState)
            .build()}
}