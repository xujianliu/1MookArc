package com.mook.base

import com.mook.model.MookModel
import io.reactivex.disposables.CompositeDisposable

open class BasePresenter<T : IBaseView>(
    protected var model: MookModel,// 可以定义个IModel  规范所有的model
    protected var view: T
) {
    protected var isLoadingLogout: Boolean = false
    protected var composite = CompositeDisposable()


    fun logout(){
        if (isLoadingLogout)return
        isLoadingLogout=true

        //TODO  logout
    }

    fun onPresenterDestroy(){
        composite.clear()
    }

}