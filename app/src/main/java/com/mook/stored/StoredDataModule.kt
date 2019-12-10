package com.mook.stored

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StoredDataModule {

    @Provides
    @Singleton
    fun providesPreferencesManager(context: Context): PreferencesManager = PreferencesManager(context)

//    @Provides
//    @Singleton
//    fun providesFormCachedService(preferencesManager: PreferencesManager): FormCachedService = FormCachedService(preferencesManager)
}