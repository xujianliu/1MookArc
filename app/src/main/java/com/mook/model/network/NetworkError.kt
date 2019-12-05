package com.mook.model.network

import com.alibaba.fastjson.JSON
import com.mook.extension.takeIfNotEmpty
import com.mook.model.network.response.BaseResponse
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException


class NetworkError(private val throwable: Throwable) {

    companion object {
        const val MESSAGE_ERROR_DEFAULT = "Something went wrong."
        const val MESSAGE_ERROR_CONNECTION = "There's problem with your connection."
        const val MESSAGE_ERROR_DEFAULT_ID = "Terjadi kesalahan."
        const val MESSAGE_ERROR_CONNECTION_ID = "Koneksi Anda bermasalah."
    }

    private val errorBody = when (throwable) {
        is HttpException -> {
            throwable.response()?.errorBody()?.string()
        }
        is ResponseException -> {
            JSON.toJSONString(throwable.response)
        }
        else -> {
            ""
        }
    }

    fun getErrorMessage(): String {
        if (throwable is IOException && throwable !is SocketTimeoutException) {
            return MESSAGE_ERROR_CONNECTION
        } else {//ResponseException 、HttpException
            getErrorResponse()?.let {
                it.message.let { message ->
                    return message?.takeIfNotEmpty(MESSAGE_ERROR_DEFAULT)
                }
            }
        }

        if (throwable is ResponseException) {
            getErrorAwanModalResponse()?.let {
                it.message.let { message ->
                    return message?.takeIfNotEmpty(MESSAGE_ERROR_DEFAULT)
                }
            }
        }
        return MESSAGE_ERROR_DEFAULT
    }


    fun isNetworkError(): Boolean =
        (throwable is IOException && throwable !is SocketTimeoutException)


    fun getErrorCode(): Int {
        return if (throwable is HttpException) {
            throwable.response()?.code()?:0
        } else {
            0
        }
    }

    private fun getErrorResponse(): BaseResponse<*>? {
        return try {
            JSON.parseObject(errorBody, BaseResponse::class.java)
        } catch (e: IOException) {
            null
        } catch (e: Exception) {
            null
        }
    }

    private fun getErrorAwanModalResponse(): BaseResponse<*>? {
        return try {
//            val userType = object : TypeToken<ModalResponse<*>>() {}.type
//            Gson().fromJson(errorBody, userType)
            JSON.parseObject(errorBody, BaseResponse::class.java)
        } catch (e: IOException) {
            null
        } catch (e: Exception) {
            null
        }
    }
}