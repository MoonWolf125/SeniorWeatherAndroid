package com.project.dahnky.seniorweatherandroid.view.nav

import android.os.Bundle
import android.widget.Toast
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.project.dahnky.seniorweatherandroid.R
import com.project.dahnky.seniorweatherandroid.core.BaseActivity
import com.project.dahnky.seniorweatherandroid.view.custom.drawer.DrawerView
import com.project.dahnky.seniorweatherandroid.view.custom.drawer.DrawerViewListener
import kotlinx.android.synthetic.main.toolbar.*

class DrawerActivity : BaseActivity(), DrawerViewListener {

    private lateinit var drawer: Drawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

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

    override fun onDrawerNavClick(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
    }
}