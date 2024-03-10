package com.example.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 5;
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0-> MyFirstFragment()
            1->SasukeFragment()
            2->SakuraFragment()
            3->KakashiFragment()
            else->Team7Fragment()
        }
    }
}