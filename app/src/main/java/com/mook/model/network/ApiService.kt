package com.mook.model.network

import com.mook.BuildConfig
import com.mook.model.network.response.AuthorInfoBean
import com.mook.model.network.response.BaseResponse
import com.mook.model.network.response.LoginResponse
import io.reactivex.Observable
import retrofit2.http.*

interface ApiService {


    /**
     * 作者信息
     */
    @GET(BuildConfig.ENDPOINT + "users/{username}")
    fun getAuthorInfo(@Path("username") username: String): Observable<BaseResponse<AuthorInfoBean>>

    @FormUrlEncoded
    @POST(BuildConfig.ENDPOINT + "user/login")
    fun login(@FieldMap request: Map<String, @JvmSuppressWildcards Any>): Observable<BaseResponse<LoginResponse>>

}