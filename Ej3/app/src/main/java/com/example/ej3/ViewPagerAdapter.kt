package com.example.ej3

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 3  // Tres fragments

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Fragment1() // Primer fragmento
            1 -> Fragment2() // Segundo fragmento
            2 -> Fragment3() // Tercer fragmento
            else -> Fragment1() // Por defecto
        }
    }
}
