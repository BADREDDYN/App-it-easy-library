package com.appiteasy.library.services

interface MyHandler {
    /**
     * Handlers.
     */
    //Handler for wait then do something.
    fun mWaitThenDo(delayMillis: Long, actionFun: () -> Unit)
}