package com.example.ej3

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Fragment1()
            1 -> Fragment2()
            2 -> Fragment3()
            else -> Fragment1()
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}
