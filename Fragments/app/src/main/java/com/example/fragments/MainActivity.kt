package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager2: ViewPager2
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager2 = findViewById(R.id.view_pager)
        viewPagerAdapter = ViewPagerAdapter(this)
        tabLayout = findViewById(R.id.tab_layout)
        viewPager2.adapter = viewPagerAdapter

        TabLayoutMediator(tabLayout, viewPager2) { tab: TabLayout.Tab, position:Int ->
            when(position) {
                0-> tab.text = "Naruto"
                1-> tab.text = "Sasuke"
                2-> tab.text = "Sakura"
                3-> tab.text = "Kakashi"
                4-> tab.text = "Team 7"
            }
        }.attach()
    }
}