package com.mook.model.network.response

import com.google.gson.annotations.SerializedName

open class BaseResponse<T>(
    @SerializedName("errorCode") val code: Int,
    @SerializedName("errorMsg") var message: String,
    val data: T
) {
    val isSuccessful: Boolean
        get() = code == 200
}
