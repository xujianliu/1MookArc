package com.mook.dashboard.mine

import com.mook.base.IBaseView
import com.mook.model.network.response.AuthorInfoBean

interface MineView : IBaseView {


    fun successGetAuthorInfo(response: AuthorInfoBean?)
}