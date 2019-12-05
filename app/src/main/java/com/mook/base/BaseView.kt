package com.mook.base

interface BaseView {

    fun showError(message: String)

    fun startLoading()

    fun stopLoading()

    fun setDelay()

    fun onAuthError()
    fun autoLogout()
    fun pageStatusError(errorMessage: String)

}