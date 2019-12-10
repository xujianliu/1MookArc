package com.mook.base

import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.mook.R
import com.mook.common.AppComponent
import com.mook.common.AppRouter
import com.mook.model.MookModel
import com.mook.stored.PreferencesManager
import com.mook.widget.ProgressDialog
import javax.inject.Inject


open class BaseActivity<V : IBaseView, P : BasePresenter<V>> : AppCompatActivity(), IBaseView {

    private var toolbar: Toolbar? = null
    protected var progressDialog: ProgressDialog? = null

//    @Inject
    lateinit var presenter: P
    @Inject
    lateinit var preferences: PreferencesManager

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        initToolbar()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }

    fun initToolbar() {
        toolbar = findViewById(R.id.toolbar)
        toolbar?.let { setSupportActionBar(it) }
    }

    protected fun getAppComponent(): AppComponent = (application as BaseApplication).appComponent

    protected fun setToolbarTitle(title: String) {
        supportActionBar?.let { it.title = title }
    }

    protected fun showToolbarBackButton(showed: Boolean) {
        supportActionBar?.let {
            it.setHomeButtonEnabled(showed)
            it.setDisplayHomeAsUpEnabled(showed)
        }
    }


    protected fun showSimpleAlertDialog(title: String?, message: String) {
        val builder = AlertDialog.Builder(this)
        title.let { builder.setTitle(it) }
        builder.setMessage(message)
        builder.setPositiveButton(R.string.ok, null)
        builder.show()
    }

    protected open fun showDialogBase(): AlertDialog.Builder {
        val builder = AlertDialog.Builder(this)
        builder.create()
        return builder
    }

    fun showProgressDialog(message: String = getString(R.string.please_wait)) {
        if (progressDialog == null) {
            progressDialog = ProgressDialog.Builder(this).setMessage(message).build()
            progressDialog?.show()
        } else if (progressDialog != null && progressDialog!!.isShowing) {
            progressDialog!!.setMessage(message)
        }

    }


    protected fun dismissProgressDialog() {
        if (progressDialog != null && progressDialog?.isShowing == true) {
            progressDialog?.dismiss()
            progressDialog = null
        }
    }


    override fun showError(message: String) {
        showSimpleAlertDialog(null, message)
    }

    override fun startLoading() {
        showProgressDialog()
    }

    override fun stopLoading() {
        dismissProgressDialog()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onPresenterDestroy()
    }

    override fun setDelay() {
    }


    override fun autoLogout() {
        preferences.clear()
        startActivity(AppRouter.getLoginActivityIntent(this))
        this.finish()
    }

    override fun pageStatusError(errorMessage: String) {

    }

    override fun onAuthError() {
        if (preferences.getUserToken().isNotEmpty()) {
            presenter.logout()
        } else {
            preferences.clear()
            startActivity(AppRouter.getLoginActivityIntent(this))
            this.finish()
        }
    }


}