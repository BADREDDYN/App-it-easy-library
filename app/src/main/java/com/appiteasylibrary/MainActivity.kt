package com.appiteasylibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.appiteasy.library.services.SoftService


class MainActivity : AppCompatActivity() {

    //Declare object from SoftService class
    private lateinit var soft: SoftService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Give it the context.
        soft = SoftService(this)

        //And use it.
        soft.run {
            mShortToast("Hello App It Easy Library!")

            mDialog(
                "Library:", "Do you like this simple library?",
                R.style.Theme_AppItEasyLibrary, {mSayHello()}, {mSayBye()}
            )
        }

    }

    private fun mSayHello() {
        soft.mLongToast("Hello!")
    }

    private fun mSayBye() {
        soft.mLongToast("Bye!")
    }
}