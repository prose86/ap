package de.prose.aandp.main.itemlist

import de.prose.aandp.BasePresenter
import de.prose.aandp.BaseView
import de.prose.aandp.database.Item

/**
 * Created by philip on 13/12/17.
 */
interface ItemListContract {

    interface ItemsView : BaseView<ItemsPresenter> {

        fun showEmptyResult()
        //todo create specific item
        fun showItems(list : List<Item>)
        fun showListLoading()
        fun hideListLoading()
    }

    interface ItemsPresenter : BasePresenter {

    }
}