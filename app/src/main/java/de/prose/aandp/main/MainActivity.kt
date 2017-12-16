package de.prose.aandp.main

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import de.prose.aandp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var viewpager: ViewPager = findViewById(R.id.viewpager_main)
        viewpager.adapter = MainPagerAdapter(supportFragmentManager)

        navigation.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.navigation_item_list -> {
                    viewpager.setCurrentItem(0, true)
                    true
                }
                R.id.navigation_add_item -> {
                    viewpager.setCurrentItem(1, true)
                    true
                }
                R.id.navigation_info -> {
                    viewpager.setCurrentItem(2, true)
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
}
