package com.mook.widget

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import com.mook.R
import kotlinx.android.synthetic.main.dialog_progress.*

class ProgressDialog(context: Context) : Dialog(context) {

    private var message: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_progress)
        textProgressMessage.text = message?.let { it } ?: context.getString(R.string.please_wait)
        setCancelable(false)
        setCanceledOnTouchOutside(false)
    }

    fun setMessage(message: String) {
        this.message = message
    }

    class Builder(context: Context) {

        val dialog = ProgressDialog(context)

        fun setMessage(message: String): Builder {
            dialog.setMessage(message)
            return this
        }

        fun build(): ProgressDialog = dialog
    }

}