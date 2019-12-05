package com.mook.model

import com.mook.extension.configured
import com.mook.extension.subscribe
import com.mook.model.network.ApiService
import com.mook.model.network.NetworkError
import com.mook.model.network.ResponseCallback
import com.mook.model.network.response.AuthorInfoBean
import io.reactivex.disposables.Disposable

class MookModel (val  apiService: ApiService){


    fun getAuthorInfo(id:Long,callback:ResponseCallback<AuthorInfoBean>):Disposable{
        return apiService
            .getAuthorInfo(id)
            .configured()
            .subscribe({callback.onSuccess(it.data)},{ error:NetworkError ->callback.onError(error)})
    }
}