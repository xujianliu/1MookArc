package com.mook.model.network.request

import java.util.*

data class BaseRequest(var language: String) {
    init {
        val localeLanguage = Locale.getDefault().language
        val country = Locale.getDefault().country
        language = "${country}_${language}"
    }
}