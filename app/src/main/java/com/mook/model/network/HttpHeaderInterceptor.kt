package com.mook.model.network

import com.mook.stored.PreferencesManager
import okhttp3.Interceptor
import okhttp3.Response

class HttpHeaderInterceptor(private val preferencesManager: PreferencesManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val userToken = preferencesManager.getUserToken()
        val builder = request.newBuilder()
//        builder.addHeader("Authorization", userToken)
//        builder.addHeader("Content-Type","application/x-www-form-urlencoded")
        return chain.proceed(builder.build())
    }
}