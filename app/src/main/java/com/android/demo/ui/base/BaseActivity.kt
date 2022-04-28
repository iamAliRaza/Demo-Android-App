package com.android.demo.ui.base
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.android.demo.ui.main.MainViewModel
import com.android.demo.utils.ViewModelProviderFactory

abstract class BaseActivity<VB : ViewBinding, T : ViewModel> : AppCompatActivity() {

    private var _viewBinding: VB? = null
    protected val binding: VB get() = _viewBinding!!

    protected abstract val bindingInflater: (LayoutInflater) -> VB
    protected abstract val viewModel : T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _viewBinding = bindingInflater(layoutInflater)
        setContentView(_viewBinding!!.root)
    }
}