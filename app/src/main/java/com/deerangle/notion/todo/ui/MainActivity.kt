package com.deerangle.notion.todo.ui

import androidx.activity.viewModels
import com.deerangle.notion.todo.R
import com.deerangle.notion.todo.databinding.ActivityMainBinding
import com.deerangle.notion.todo.utils.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {
    override val viewModel: MainViewModel by viewModels()

    override fun setupView() {
    }

    override fun setupObserver() {
    }
}
