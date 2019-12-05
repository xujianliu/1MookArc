package com.mook.stored

import android.content.Context

class PreferencesManager(context: Context) {
    companion object {
        const val KEY_TOKEN="user_token"
    }

    private var preferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    private var onbPreferences = context.getSharedPreferences(context.packageName + ".onb", Context.MODE_PRIVATE)



    fun getUserToken(): String = preferences.getString(KEY_TOKEN, "").toString()

    fun saveUserToken(token: String) {
        preferences.edit().putString(KEY_TOKEN, token).apply()
    }


    fun clear() {
        preferences.edit().clear().apply()
    }

}