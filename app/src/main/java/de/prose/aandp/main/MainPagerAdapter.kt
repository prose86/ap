package de.prose.aandp.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import de.prose.aandp.main.additem.AddItemFragment
import de.prose.aandp.main.info.InfoFragment
import de.prose.aandp.main.itemlist.ItemListFragment

/**
 * Created by philip on 13/12/17.
 */
class MainPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    private val NUMBER_OF_PAGES = 3

    override fun getItem(position: Int): Fragment? =
            when (position) {
                0 -> ItemListFragment()
                1 -> AddItemFragment()
                2 -> InfoFragment()
                else -> {
                    null
                }
            }


    override fun getCount() = NUMBER_OF_PAGES

}