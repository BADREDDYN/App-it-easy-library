package com.appiteasy.library.services

interface MyDialog {
    /**
     *Dialogs with a different types.
     */
    //Simple dialogs.
    fun mDialog(
        title: String, message: String, alertDialogTheme: Int,
        mFunYes: () -> Unit
    )
    fun mDialog(
        title: String, message: String, alertDialogTheme: Int,
        mFunYes: () -> Unit, mFunNo: () -> Unit
    )

    //Dialogs support multi languages.
    fun mDialogLang(
        title: String, message: String, yes: Int, no: Int, alertDialogTheme: Int,
        mFunYes: () -> Unit
    )
    fun mDialogLang(
        title: String, message: String, yes: Int, no: Int, close: Int,
        alertDialogTheme: Int,
        mFunYes: () -> Unit, mFunNo: () -> Unit
    )
}