package com.mook.dashboard.mine

import android.os.Bundle
import com.mook.R
import com.mook.base.BaseActivity
import com.mook.model.MookModel
import com.mook.model.network.response.AuthorInfoBean
import com.mook.stored.PreferencesManager
import javax.inject.Inject

class MineActivity : BaseActivity<MineView, MinePresenter>(), MineView {

    @Inject
    lateinit var mookModel: MookModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getAppComponent().inject(this)
        setContentView(R.layout.activity_mine)
        showToolbarBackButton(true)
        setToolbarTitle("我的")
        presenter = MinePresenter(mookModel, this)
//        presenter.getAuthorInfo("liuxujian")
    }

    override fun successGetAuthorInfo(response: AuthorInfoBean?) {
    }
}
