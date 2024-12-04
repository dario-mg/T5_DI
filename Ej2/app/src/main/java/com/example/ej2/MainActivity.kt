package com.example.ej2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar el Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.navview)

        // Configurar NavHostFragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration.Builder(
            R.id.nav_home, R.id.nav_gallery, R.id.nav_slidebar
        )
            .setOpenableLayout(drawerLayout)
            .build()

        // Integrar Toolbar, NavigationView y NavController
        setupActionBarWithNavController(navController, appBarConfiguration)
        NavigationUI.setupWithNavController(navView, navController)

    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = NavHostFragment.findNavController(
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment)!!
        )
        return NavigationUI.navigateUp(
            navController,
            appBarConfiguration
        ) || super.onSupportNavigateUp()
    }
}