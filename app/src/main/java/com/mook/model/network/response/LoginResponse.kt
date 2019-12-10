package com.mook.model.network.response

data class LoginResponse(
    val admin: Boolean,
    //置顶的章节
    val chapterTops: List<Any>,
    //收藏的
    val collectIds: List<Any>,
    val email: String,
    val icon: String,
    val id: Int,
    val nickname: String,
    val password: String,
    val publicName: String,
    val token: String,
    val type: Int,
    val username: String
)