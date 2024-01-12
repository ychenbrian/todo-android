package com.deerangle.notion.todo.ui.home

import androidx.fragment.app.viewModels
import com.deerangle.notion.todo.R
import com.deerangle.notion.todo.databinding.FragmentHomeBinding
import com.deerangle.notion.todo.utils.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {
    override val viewModel: HomeViewModel by viewModels()

    override fun setupView() {
    }

    override fun setupObserver() {
    }
}
