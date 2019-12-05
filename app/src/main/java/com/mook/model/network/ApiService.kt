package com.mook.model.network

import com.mook.model.network.response.AuthorInfoBean
import com.mook.model.network.response.BaseResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    /**
     * 作者信息
     */
    @GET("v4/pgcs/detail/tab?")
    fun getAuthorInfo(@Query("id") id: Long):Observable<BaseResponse<AuthorInfoBean>>

}