package com.mook.common

import android.content.Context
import android.content.Intent
import com.mook.dashboard.login.LoginActivity

class AppRouter {
    companion object {
        fun getLoginActivityIntent(context: Context): Intent {
            val intent = Intent(context, LoginActivity::class.java)
            return intent
        }

    }
}