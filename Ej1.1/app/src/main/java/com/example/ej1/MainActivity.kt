package com.example.ej1

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
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

        // Configurar DrawerLayout y NavigationView
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.navview)

        // Configurar NavHostFragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController

        // Configurar AppBarConfiguration
        appBarConfiguration = AppBarConfiguration.Builder(
            R.id.nav_home, R.id.nav_spam, R.id.nav_trash
        )
            .setOpenableLayout(drawerLayout)
            .build()

        // Integrar Toolbar, NavigationView y NavController
        setupActionBarWithNavController(navController, appBarConfiguration)
        NavigationUI.setupWithNavController(navView, navController)

        // Configurar el Spinner dentro del header del NavigationView
        val headerView = navView.getHeaderView(0) // Obtener la vista del header
        val spinner: Spinner = headerView.findViewById(R.id.spinner)

        // Configurar adaptador para el Spinner
        val items = listOf("carladom@gmail.com", "correoprueba2@gmail.com", "correo3@gmail.com")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

    }

    // Método para gestionar el botón de navegación de la Toolbar
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
