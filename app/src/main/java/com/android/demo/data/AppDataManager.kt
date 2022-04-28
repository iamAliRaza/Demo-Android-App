package com.android.demo.data

import com.android.demo.data.local.prefs.PreferenceHelper

// We can add many data sources in this class e.g RoomDb, SharedPref, DataStore etc
// Currently we are just using SharedPref data would be save locally so not using any LiveData returning data directly
class AppDataManager (private val preferenceHelper: PreferenceHelper) : DataManager {

    override fun saveData(data: String) = preferenceHelper.saveData(data)
    override fun getData(): String = preferenceHelper.getData()
}