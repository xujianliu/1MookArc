package com.mook.model.network.response

open class BaseResponse<T>(
    val code: Int,
    var message: String,
    val data:T
) {
    val isSuccessful: Boolean
        get() = code == 200
}
