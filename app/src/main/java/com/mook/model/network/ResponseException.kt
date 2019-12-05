package com.mook.model.network

import com.mook.model.network.response.BaseResponse

class ResponseException:Exception {


    private val code: Int
    override val message: String
    @Transient
    val response: BaseResponse<*>

    constructor(response: BaseResponse<*>) {
        this.response = response
        this.code=response.code
        this.message=response.message
    }


}