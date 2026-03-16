package com.qomunal.opensource.androidresearch.ui.main

import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.viewModels
import com.qomunal.opensource.androidresearch.common.base.BaseActivity
import com.qomunal.opensource.androidresearch.databinding.ActivityMainBinding
import com.qomunal.opensource.androidresearch.util.Constant.EXTRA_TEXT

class MainActivity : BaseActivity<ActivityMainBinding>() {

    companion object {
        const val RESULT_CODE = 1111111
    }

    private val viewModel: MainViewModel by viewModels()

    private val router: MainRouter by lazy {
        MainRouter(this)
    }

    override fun setupOnActivityResult(result: ActivityResult) {
        super.setupOnActivityResult(result)
        when (result.resultCode) {
            RESULT_CODE -> {
                val text = result.data?.getStringExtra(EXTRA_TEXT)
                binding.tvText.text = text
            }
        }
    }

    override fun setupViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initUI() {
        binding.apply {
            btnTest.setOnClickListener {
                // TODO your work
                startActivityResult.launch(router.toSingle1())
            }
        }
    }

    override fun initObserver() {
        viewModel.apply {

        }
    }

}