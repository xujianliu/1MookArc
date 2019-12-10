package com.mook.dashboard.login

import com.mook.base.BasePresenter
import com.mook.common.AppConstants
import com.mook.model.MookModel
import com.mook.model.network.NetworkError
import com.mook.model.network.ResponseCallback
import com.mook.model.network.request.LoginRequest
import com.mook.model.network.response.LoginResponse

class LoginPresenter(model: MookModel, view: LoginView) : BasePresenter<LoginView>(model, view) {

    fun login(loginRequest: LoginRequest) {
        view.startLoading()
        val disposable = model.login(loginRequest, object : ResponseCallback<LoginResponse> {
            override fun onSuccess(response: LoginResponse?) {
                view.stopLoading()
                view.successfulLogin(response)
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