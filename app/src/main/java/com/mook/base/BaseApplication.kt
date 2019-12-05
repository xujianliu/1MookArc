package com.mook.base

import android.app.Activity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import com.mook.common.AppComponent

class BaseApplication :MultiDexApplication(){

    lateinit var appComponent: AppComponent

    companion object{
        private val TAG=this::class.java.simpleName
    }

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder().build())
//        appComponent=Dag
        registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks)

    }

    private val mActivityLifecycleCallbacks= object :ActivityLifecycleCallbacks{
        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            Log.d(TAG,"onActivityCreated${activity.componentName.className}")
        }

        override fun onActivityStarted(activity: Activity) {
            Log.d(TAG,"onActivityStarted${activity.componentName.className}")
        }

        override fun onActivityResumed(activity: Activity) {

        }

        override fun onActivityPaused(activity: Activity) {

        }

        override fun onActivityStopped(activity: Activity) {

        }

        override fun onActivityDestroyed(activity: Activity) {
            Log.d(TAG,"onActivityDestroyed${activity.componentName.className}")
        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

        }
    }
}