package com.android.demo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.demo.R
import com.android.demo.data.DataManager
import com.android.demo.data.DataResource
import com.android.demo.data.DataStatus

class MainViewModel(private val dataManager: DataManager) : ViewModel() {

    private val _liveData: MutableLiveData<DataResource<String>> = MutableLiveData()
    val liveData: LiveData<DataResource<String>> = _liveData

    fun saveUserInputData(data: String) {
        if (data.isEmpty()) _liveData.value = DataResource.error(R.string.req_message)
        else {
            dataManager.saveData(data)
            _liveData.value = DataResource.success(getUserInputData())
        }
    }

    private fun getUserInputData() = dataManager.getData()
}