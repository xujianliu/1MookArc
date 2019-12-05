package com.mook.model.network

interface ResponseCallback<T>{
    fun onSuccess(response: T?)
    fun onError(error: NetworkError)
}


interface ResponseCallbackAwanModal {
    fun onSuccess()
    fun onError(error: NetworkError)
}
