package com.project.dahnky.sacweather.view.nav

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Toast
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.project.dahnky.sacweather.core.BaseActivity
import com.project.dahnky.sacweather.view.custom.drawer.DrawerView
import com.project.dahnky.sacweather.view.custom.drawer.DrawerViewListener
import com.project.dahnky.sacweather.view.nav.home.HomeFragment
import com.project.dahnky.sacweather.view.nav.info.InfoFragment
import kotlinx.android.synthetic.main.toolbar.*
import com.project.dahnky.sacweather.R

class DrawerActivity : BaseActivity(), DrawerViewListener {

    private lateinit var drawer: Drawer
    private lateinit var drawerSelection: DrawerViewListener.DrawerSelection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        checkRequestPermissions()
        setupDrawer(savedInstanceState)
        this.drawerSelection = DrawerViewListener.DrawerSelection.HOME
        startFragment(R.id.frame_container, HomeFragment.newInstance(this), false)
    }

    override fun onDrawerNavClick(drawerSelection: DrawerViewListener.DrawerSelection) {
        if (drawerSelection != this.drawerSelection) {
            this.drawerSelection = drawerSelection
            when (drawerSelection) {
                DrawerViewListener.DrawerSelection.HOME -> {
                    startFragment(R.id.frame_container, HomeFragment.newInstance(this), false)
                }
//                DrawerViewListener.DrawerSelection.EMBEDDED -> {
//                    Toast.makeText(this, "Embedded", Toast.LENGTH_LONG).show()
//                }
                DrawerViewListener.DrawerSelection.INFO -> {
                    startFragment(R.id.frame_container, InfoFragment.newInstance(), false)
                    toolbar.title = "Information"
                }
            }
            drawer.closeDrawer()
        }
    }

    override fun setToolbarTitle(title: String) {
        toolbar.title = title
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            permRequestCode -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    startFragment(R.id.frame_container, HomeFragment.newInstance(this), false)
                }
                return
            }
        }
    }

    private fun checkRequestPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), permRequestCode)
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
            .build()
    }
}