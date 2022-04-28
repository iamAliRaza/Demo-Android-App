package com.android.demo.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.demo.DemoApplication
import com.android.demo.data.AppDataManager
import com.android.demo.data.local.prefs.AppPreferenceHelper
import com.android.demo.ui.main.MainViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelProviderFactory : ViewModelProvider.Factory{

    companion object {
        private var instance : ViewModelProviderFactory? = null
        fun getInstance () =  instance ?: ViewModelProviderFactory().also { instance = it}
    }

    // As we just have single view model in this demo app that's why using this kind of approach
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java))  return MainViewModel (AppDataManager(AppPreferenceHelper(DemoApplication.getInstance()))) as T
        else {
            throw IllegalArgumentException("Unknown Class name "+ modelClass.name)
        }
    }
}