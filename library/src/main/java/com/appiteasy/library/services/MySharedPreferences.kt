package com.appiteasy.library.services

interface MySharedPreferences {
    /**
     * SharedPreferences to saving data locally.
     */
    //Setters.
    fun mSetSP(folderName: String, key: String, value: String)

    fun mSetSP(folderName: String, key: String, value: Int)

    fun mSetSP(folderName: String, key: String, value: Boolean)

    fun mSetSP(folderName: String, key: String, value: Float)

    fun mSetSP(folderName: String, key: String, value: Long)

    //Getters.
    fun mGetSP(folderName: String, key: String, defValue: String = ""): String?

    fun mGetSP(folderName: String, key: String, defValue: Int = 0): Int

    fun mGetSP(folderName: String, key: String, defValue: Boolean = false): Boolean

    fun mGetSP(folderName: String, key: String, defValue: Float = 0f): Float

    fun mGetSP(folderName: String, key: String, defValue: Long = 0): Long
}