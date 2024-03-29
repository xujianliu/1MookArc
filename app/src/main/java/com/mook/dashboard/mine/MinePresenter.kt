package com.mook.dashboard.mine

import com.mook.base.BasePresenter
import com.mook.common.AppConstants
import com.mook.model.MookModel
import com.mook.model.network.NetworkError
import com.mook.model.network.ResponseCallback
import com.mook.model.network.response.AuthorInfoBean

class MinePresenter(model: MookModel, view: MineView) : BasePresenter<MineView>(model, view) {

    fun getAuthorInfo(username: String) {
        view.startLoading()

        val disposable = model.getAuthorInfo(username, object : ResponseCallback<AuthorInfoBean> {
            override fun onSuccess(response: AuthorInfoBean?) {
                view.stopLoading()
                view.successGetAuthorInfo(response)
            }

            override fun onError(error: NetworkError) {
                view.stopLoading()
                if (error.getErrorCode() == AppConstants.AUTH_ERROR_CODE) {
                    view.onAuthError()
                } else {
                    view.pageStatusError(error.getErrorMessage())
                }
            }
        })
        composite.add(disposable)
    }

}