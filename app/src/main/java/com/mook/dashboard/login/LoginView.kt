package com.mook.dashboard.login

import com.mook.base.IBaseView
import com.mook.model.network.response.LoginResponse

interface LoginView : IBaseView {
    fun successfulLogin(response: LoginResponse?)

}