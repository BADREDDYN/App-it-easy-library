package com.appiteasy.library.services

import android.app.Activity

interface MyIntent {
    /**
     * Intent.
     */
    //Using Intent to moving to another activity.
    fun mMoveToActivity(activity: Class<out Activity?>)
}