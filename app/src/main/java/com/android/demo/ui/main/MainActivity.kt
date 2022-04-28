package com.android.demo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.android.demo.data.DataStatus
import com.android.demo.databinding.ActivityMainBinding
import com.android.demo.ui.base.BaseActivity
import com.android.demo.utils.ViewModelProviderFactory

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.saveButton.setOnClickListener {
            viewModel.saveUserInputData(binding.editText.text.toString())
        }

        viewModel.liveData.observe(this) {
            when(it.status) {
                DataStatus.ERROR -> {
                   binding.editText.error = it.messageResId?.let { resId -> getString(resId) }
                }
                DataStatus.SUCCESS -> {
                    binding.textView.text = it.data
                }
            }
        }
    }

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override val viewModel: MainViewModel
        get() = ViewModelProvider(this, ViewModelProviderFactory.getInstance()).get(MainViewModel::class.java)
}