package com.deerangle.notion.todo.utils.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.deerangle.notion.todo.BR

abstract class BaseActivity<DB : ViewDataBinding, VM : ViewModel>(
    @LayoutRes private val layoutId: Int,
) : AppCompatActivity() {
    protected lateinit var binding: DB
    protected abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize DataBinding
        binding = DataBindingUtil.setContentView(this, layoutId)

        // Set the ViewModel for DataBinding
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, viewModel)

        // Call the setupObserver function to perform observer setup
        setupObserver()

        // Call the setupView function to perform additional view setup
        setupView()
    }

    // This function can be overridden in concrete fragments
    // to perform additional setup for views if needed.
    abstract fun setupView()

    // This function can be overridden in concrete fragments
    // to add observers.
    abstract fun setupObserver()
}
