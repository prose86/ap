package de.prose.aandp.main.itemlist

import android.support.annotation.MainThread
import android.util.Log
import rx.Observable
import rx.Observer
import rx.Subscriber
import rx.Subscription
import rx.schedulers.Schedulers
import rx.android.schedulers.AndroidSchedulers
import rx.internal.operators.OperatorReplay.observeOn
import java.util.concurrent.TimeUnit


/**
 * Created by philip on 13/12/17.
 */
class ItemListPresenterImpl(private val itemsView: ItemListContract.ItemsView) : ItemListContract.ItemsPresenter {

    private var mSubscription: Subscription? = null

    init {
        itemsView.setPresenter(this)
    }

    override fun start() {
        itemsView.showListLoading()
        loadItems()
    }

    override fun stop() {
        mSubscription?.unsubscribe()
    }

    private fun loadItems() {
        var obsList: MutableList<String> = ArrayList<String>();
        obsList.add("first")
        obsList.add("second")
        obsList.add("third")


        var observer = Observable.create(object : Observable.OnSubscribe<List<String>> {
            override fun call(t: Subscriber<in List<String>>) {
                t.onNext(obsList)
            }

        }).debounce(1000, TimeUnit.MILLISECONDS )
        mSubscription = observer.subscribe(object : Subscriber<List<String>>() {
            override fun onCompleted() {
                //Completed
                Log.i("prose", "onCompleted");
            }

            override fun onError(e: Throwable?) {
                //TODO : Handle error here
                Log.i("prose", "onError"+"error");
            }

            override fun onNext(t: List<String>?) {
                Log.i("prose", "onNext"+t.toString());
            }
        })

        Log.i("prose", "Adding afterwards")
        obsList.add("fourth")

    }
}