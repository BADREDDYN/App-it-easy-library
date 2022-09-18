package com.appiteasy.library.services

import android.app.Activity
import android.app.Application
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.ContextThemeWrapper
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class SoftService(context: Context) : Application(), MyToast, MySharedPreferences, MyDialog, MyClipBoard,
    MyIntent, MyHandler {

    private var context: Context

    init {
        this.context = context
    }



    override fun mShortToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
    override fun mLongToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }


    override fun mSetSP(folderName: String, key: String, value: String) {
        context.getSharedPreferences(folderName, Context.MODE_PRIVATE)
            .edit().putString(key, value).apply()
    }
    override fun mSetSP(folderName: String, key: String, value: Int) {
        context.getSharedPreferences(folderName, Context.MODE_PRIVATE)
            .edit().putInt(key, value).apply()
    }
    override fun mSetSP(folderName: String, key: String, value: Boolean) {
        context.getSharedPreferences(folderName, Context.MODE_PRIVATE)
            .edit().putBoolean(key, value).apply()
    }
    override fun mSetSP(folderName: String, key: String, value: Float) {
        context.getSharedPreferences(folderName, Context.MODE_PRIVATE)
            .edit().putFloat(key, value).apply()
    }
    override fun mSetSP(folderName: String, key: String, value: Long) {
        context.getSharedPreferences(folderName, Context.MODE_PRIVATE)
            .edit().putLong(key, value).apply()
    }

    override fun mGetSP(folderName: String, key: String, defValue: String): String? {
        return context.getSharedPreferences(folderName, Context.MODE_PRIVATE)
            .getString(key, defValue)
    }
    override fun mGetSP(folderName: String, key: String, defValue: Int): Int {
        return context.getSharedPreferences(folderName, Context.MODE_PRIVATE)
            .getInt(key, defValue)
    }
    override fun mGetSP(folderName: String, key: String, defValue: Boolean): Boolean {
        return context.getSharedPreferences(folderName, Context.MODE_PRIVATE)
            .getBoolean(key, defValue)
    }
    override fun mGetSP(folderName: String, key: String, defValue: Float): Float {
        return context.getSharedPreferences(folderName, Context.MODE_PRIVATE)
            .getFloat(key, defValue)
    }
    override fun mGetSP(folderName: String, key: String, defValue: Long): Long {
        return context.getSharedPreferences(folderName, Context.MODE_PRIVATE)
            .getLong(key, defValue)
    }


    override fun mDialog(
        title: String, message: String, alertDialogTheme: Int,
        mFunYes: () -> Unit
    ) {
        MaterialAlertDialogBuilder(
            ContextThemeWrapper(
                context,
                alertDialogTheme
            )
        )
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("Yes") { _, _ ->

                mFunYes()

            }
            .setNeutralButton("Close") { _, _ -> }
            .show()
    }
    override fun mDialog(
        title: String, message: String, alertDialogTheme: Int,
        mFunYes: () -> Unit, mFunNo: () -> Unit
    ) {
        MaterialAlertDialogBuilder(
            ContextThemeWrapper(
                context,
                alertDialogTheme
            )
        )
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("Yes") { _, _ ->
                mFunYes()
            }
            .setNegativeButton("No") { _, _ ->
                mFunNo()
            }.setNeutralButton("Close") { _, _ -> }
            .show()
    }

    override fun mDialogLang(
        title: String, message: String, yes: Int, close: Int, alertDialogTheme: Int,
        mFunYes: () -> Unit
    ) {
        MaterialAlertDialogBuilder(
            ContextThemeWrapper(
                context,
                alertDialogTheme
            )
        )
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(yes) { _, _ ->
                mFunYes()
            }
            .setNeutralButton(close) { _, _ -> }
            .show()
    }
    override fun mDialogLang(
        title: String, message: String, yes: Int, no: Int, close: Int,
        alertDialogTheme: Int,
        mFunYes: () -> Unit, mFunNo: () -> Unit
    ) {
        MaterialAlertDialogBuilder(
            ContextThemeWrapper(
                context,
                alertDialogTheme
            )
        )
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(yes) { _, _ ->
                mFunYes()
            }
            .setNegativeButton(no) { _, _ ->
                mFunNo()
            }.setNeutralButton(close) { _, _ -> }
            .show()
    }


    override fun mClipBoard(label: String, text: String) {

        (context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager).apply {
            setPrimaryClip(ClipData.newPlainText(label, text))
        }

    }


    override fun mMoveToActivity(activity: Class<out Activity?>) {
        context.also {
            it.startActivity(
                Intent(it, activity)
            )
        }
    }


    override fun mWaitThenDo(delayMillis: Long, actionFun: () -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed({
            actionFun()
        }, delayMillis)
    }

}