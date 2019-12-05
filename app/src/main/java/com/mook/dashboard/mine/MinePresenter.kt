package com.mook.dashboard.mine

import com.mook.base.BasePresenter
import com.mook.base.MookConstants
import com.mook.model.MookModel
import com.mook.model.network.NetworkError
import com.mook.model.network.ResponseCallback
import com.mook.model.network.response.AuthorInfoBean

class MinePresenter(model: MookModel, view: MineView) : BasePresenter<MineView>(model, view) {


    fun getAuthorInfo(id: Long) {
        view.startLoading()

        val disposable = model.getAuthorInfo(id, object : ResponseCallback<AuthorInfoBean> {
            override fun onSuccess(response: AuthorInfoBean?) {
                view.stopLoading()
                view.successGetAuthorInfo(response)
            }

            override fun onError(error: NetworkError) {
                view.stopLoading()
                if (error.getErrorCode() == MookConstants.AUTH_ERROR_CODE) {
                    view.onAuthError()
                } else {
                    view.pageStatusError(error.getErrorMessage())
                }
            }
        })
        composite.add(disposable)
    }

}