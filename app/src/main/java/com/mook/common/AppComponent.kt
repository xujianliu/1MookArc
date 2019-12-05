package com.mook.common

import com.mook.MainActivity
import com.mook.dashboard.login.ui.login.LoginActivity
import com.mook.dashboard.mine.MineActivity
import com.mook.model.network.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {

    fun inject(mineActivity: MineActivity)
    fun inject(mainActivity: MainActivity)
    fun inject(loginActivity: LoginActivity)
}