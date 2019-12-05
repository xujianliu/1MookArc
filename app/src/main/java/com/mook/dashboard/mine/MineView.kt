package com.mook.dashboard.mine

import com.mook.base.BaseView
import com.mook.model.network.response.AuthorInfoBean

interface MineView : BaseView {


    fun successGetAuthorInfo(response: AuthorInfoBean?)
}