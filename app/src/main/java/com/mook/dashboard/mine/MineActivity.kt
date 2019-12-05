package com.mook.dashboard.mine

import android.os.Bundle
import com.mook.R
import com.mook.base.BaseActivity
import com.mook.model.network.response.AuthorInfoBean

class MineActivity : BaseActivity<MineView, MinePresenter>(), MineView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_mine)
        presenter = MinePresenter(model, this)
        presenter.getAuthorInfo(123456)
    }

    override fun successGetAuthorInfo(response: AuthorInfoBean?) {
    }
}
