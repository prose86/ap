package de.prose.aandp

/**
 * Created by philip on 13/12/17.
 */
interface BaseView<T : BasePresenter> {
    fun setPresenter(presenter : T)
}