package com.mook.common

import com.mook.MainActivity
import com.mook.dashboard.login.LoginActivity
import com.mook.dashboard.mine.MineActivity
import com.mook.module.AppModule
import com.mook.module.NetworkModule
import com.mook.stored.StoredDataModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class,
        StoredDataModule::class,
        NetworkModule::class
//        ,
//        PresenterModule::class
    ]
)
interface AppComponent {

    fun inject(mineActivity: MineActivity)

    fun inject(mainActivity: MainActivity)

    fun inject(loginActivity: LoginActivity)
}