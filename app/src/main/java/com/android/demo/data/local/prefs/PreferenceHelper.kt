package com.android.demo.data.local.prefs

interface PreferenceHelper {

    fun saveData (data : String)
    fun getData () : String
}