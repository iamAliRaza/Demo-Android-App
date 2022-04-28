package com.android.demo.data.local.prefs

import android.content.Context
import android.content.SharedPreferences
import com.android.demo.utils.AppConstants

class AppPreferenceHelper (context: Context?) : PreferenceHelper {

    companion object {
        private const val USER_DATA_KEY = "USER_DATA_KEY"
    }

    private val mPrefs : SharedPreferences? = context?.getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE)

    override fun saveData(data: String) {
        mPrefs?.edit()?.putString(USER_DATA_KEY, data)?.apply()
    }

    override fun getData(): String  = mPrefs?.getString(USER_DATA_KEY, "") ?: ""
}