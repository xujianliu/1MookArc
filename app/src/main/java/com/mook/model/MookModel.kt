package com.mook.model

import com.alibaba.fastjson.JSON
import com.mook.extension.configured
import com.mook.extension.subscribe
import com.mook.model.network.ApiService
import com.mook.model.network.NetworkError
import com.mook.model.network.ResponseCallback
import com.mook.model.network.request.LoginRequest
import com.mook.model.network.response.AuthorInfoBean
import com.mook.model.network.response.LoginResponse
import io.reactivex.disposables.Disposable

class MookModel(private val apiService: ApiService) {


    fun getAuthorInfo(username: String, callback: ResponseCallback<AuthorInfoBean>): Disposable {
        return apiService
            .getAuthorInfo(username)
            .configured()
            .subscribe({ callback.onSuccess(it.data) },
                { error: NetworkError -> callback.onError(error) })
    }

    fun login(request: LoginRequest, callback: ResponseCallback<LoginResponse>): Disposable {
        val requestMap = JSON.parseObject(JSON.toJSONString(request))
        return apiService.login(requestMap)
            .configured()
            .subscribe({ callback.onSuccess(it.data) },
                { error: NetworkError -> callback.onError(error) })
    }
}