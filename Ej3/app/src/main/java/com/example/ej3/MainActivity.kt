package com.example.ej3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.tabs.TabLayoutMediator
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)

        // Configurar el ViewPager con el adaptador
        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        // Sincronizar el TabLayout con el ViewPager
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Tab 1"
                1 -> tab.text = "Tab 2"
                2 -> tab.text = "Tab 3"
            }
        }.attach()
    }
}
