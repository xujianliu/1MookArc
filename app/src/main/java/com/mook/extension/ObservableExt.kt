package com.mook.extension

import com.mook.model.network.NetworkError
import com.mook.model.network.ResponseException
import com.mook.model.network.response.BaseResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


fun <T : Any> Observable<T>.configured(): Observable<T> {
    return this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .onErrorResumeNext { throwable: Throwable -> Observable.error(throwable) }
}

fun <T : Any> Observable<T>.subscribe2(onSuccess: (T) -> Unit, onError: (NetworkError) -> Unit): Disposable =
    this.subscribe({ response: T -> onSuccess(response) }, { throwable: Throwable -> onError(
        NetworkError(throwable)
    ) })

fun <T : Any> Observable<BaseResponse<T>>.subscribe(onSuccess: (BaseResponse<T>) -> Unit, onError: (NetworkError) -> Unit): Disposable {

    return this.subscribe({ response: BaseResponse<T> ->
        when (response.code) {
            200 -> {
                onSuccess(response)
            }
            500, 503 -> {
                response.message = "network error"
                val responseException =
                    ResponseException(response)
                val networkError =
                    NetworkError(responseException)
                onError(networkError)
            }
            else -> {
                val responseException = ResponseException(response)
                val networkError = NetworkError(responseException)
                onError(networkError)
            }
        }
    }, { throwable: Throwable -> onError(NetworkError(throwable)) })
}

