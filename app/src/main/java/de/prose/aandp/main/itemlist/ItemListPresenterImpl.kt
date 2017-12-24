package de.prose.aandp.main.itemlist
import de.prose.aandp.database.ItemDao
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by philip on 13/12/17.
 */
class ItemListPresenterImpl(private val itemsView: ItemListContract.ItemsView, private  val itemDao: ItemDao) : ItemListContract.ItemsPresenter {

    private var disposal : CompositeDisposable

    init {
        itemsView.setPresenter(this)
        disposal = CompositeDisposable()
    }

    override fun start() {
        itemsView.showListLoading()
        disposal.add(loadItems())
    }

    override fun stop() {
        disposal.clear()
    }

    private fun loadItems() =
        itemDao.getAllItems().observeOn(AndroidSchedulers.mainThread()).subscribe({ it ->
            itemsView.hideListLoading()
            if (it.size == 0) itemsView.showEmptyResult() else itemsView.showItems(it)
        })
}