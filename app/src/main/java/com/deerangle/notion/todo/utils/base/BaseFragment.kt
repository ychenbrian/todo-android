package com.deerangle.notion.todo.utils.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.deerangle.notion.todo.BR

abstract class BaseFragment<DB : ViewDataBinding, VM : ViewModel>(
    @LayoutRes private val layoutId: Int,
) : Fragment() {
    protected lateinit var binding: DB
    protected abstract val viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

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
