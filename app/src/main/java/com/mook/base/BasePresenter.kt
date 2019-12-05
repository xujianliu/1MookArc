package com.mook.base

import com.mook.model.MookModel
import io.reactivex.disposables.CompositeDisposable

open class BasePresenter<T : BaseView>(
    protected var model: MookModel,
    protected var view: T
) {
    protected var isLoadingLogout: Boolean = false
    protected var composite = CompositeDisposable()


    fun logout(){
        if (isLoadingLogout)return
        isLoadingLogout=true

        //TODO  logout
    }

    fun destroy(){
        composite.clear()
    }

}