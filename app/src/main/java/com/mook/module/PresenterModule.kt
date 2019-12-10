package com.mook.module

import com.mook.dashboard.mine.MinePresenter
import com.mook.dashboard.mine.MineView
import com.mook.model.MookModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun providesMinePresenter(mookModel: MookModel,mineView: MineView): MinePresenter {
        return MinePresenter(mookModel, mineView)
    }

}