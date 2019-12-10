package com.mook.dashboard.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.mook.R
import com.mook.base.BaseActivity
import com.mook.dashboard.mine.MineActivity
import com.mook.model.MookModel
import com.mook.model.network.request.LoginRequest
import com.mook.model.network.response.LoginResponse
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity<LoginView, LoginPresenter>(), LoginView {
    @Inject
    lateinit var mookModel: MookModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getAppComponent().inject(this)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenter(mookModel, this)
        btn_login.setOnClickListener {
            if (et_username.text.isNullOrBlank() || et_password.text.isNullOrBlank()) {
                return@setOnClickListener
            }
            val loginRequest =
                LoginRequest(et_username.text.toString(), et_password.text.toString())
            presenter.login(loginRequest)
        }


    }

    override fun successfulLogin(response: LoginResponse?) {

        Toast.makeText(this, "login successful${response?.nickname}", Toast.LENGTH_SHORT).show()

        startActivity(Intent(this, MineActivity::class.java))
        finish()
    }
}
