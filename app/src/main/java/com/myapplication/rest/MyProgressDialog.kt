package com.myapplication.rest

import android.app.AlertDialog
import android.content.Context
import android.graphics.drawable.ColorDrawable

import com.myapplication.R

class MyProgressDialog(context: Context) : AlertDialog(context) {

    init {
        window!!.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
    }

    override fun show() {
        super.show()
        setContentView(R.layout.dialog_progress)
    }
}