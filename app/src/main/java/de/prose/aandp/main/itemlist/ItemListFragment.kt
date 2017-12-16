package de.prose.aandp.main.itemlist


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import de.prose.aandp.R


/**
 * A simple [Fragment] subclass.
 */
class ItemListFragment : Fragment(), ItemListContract.ItemsView  {

    var mPresenter : ItemListContract.ItemsPresenter? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        ItemListPresenterImpl(this)
        return inflater!!.inflate(R.layout.fragment_item_list, container, false)
    }

    override fun onResume() {
        super.onResume()
        mPresenter!!.start()
    }

    override fun onPause() {
        super.onPause()
        mPresenter!!.stop()
    }
    override fun setPresenter(presenter: ItemListContract.ItemsPresenter) {
        mPresenter = checkNotNull(presenter)
    }

    override fun showEmptyResult() {
    }

    override fun showItems(list: List<Any>) {
    }

    override fun showListLoading() {

    }

    override fun hideListLoading() {
    }
}
