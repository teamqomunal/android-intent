package com.qomunal.opensource.androidresearch.ui.multiple

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.qomunal.opensource.androidresearch.common.base.BaseActivity
import com.qomunal.opensource.androidresearch.databinding.ActivitySingleBinding
import com.qomunal.opensource.androidresearch.ui.detail.DetailViewModel
import com.qomunal.opensource.androidresearch.util.Constant.EXTRA_TEXT

class SingleActivity2 : BaseActivity<ActivitySingleBinding>() {

    companion object {

        const val RESULT_CODE = 9002

        fun createIntent(context: Context): Intent {
            return Intent(context, SingleActivity2::class.java).apply {

            }
        }

        fun launch(activity: AppCompatActivity) {
            activity.startActivity(createIntent(activity))
        }
    }

    override fun setupOnActivityResult(result: ActivityResult) {
        super.setupOnActivityResult(result)
        when (result.resultCode) {
            RESULT_CODE -> {
                val text = result.data?.getStringExtra(EXTRA_TEXT)
                binding.tvText.text = text
                setResult(SingleActivity1.RESULT_CODE, Intent().apply {
                    putExtra(EXTRA_TEXT, "${text} and 2")
                })
                finish()
            }
        }
    }

    private val viewModel: DetailViewModel by viewModels()

    private val router: SingleRouter by lazy {
        SingleRouter(this)
    }

    override fun setupViewBinding(): ActivitySingleBinding {
        return ActivitySingleBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initUI() {
        binding.apply {
            tvTitle.text = "Single 2"

            btnTest.setOnClickListener {
                startActivityResult.launch(router.toSingle3())
            }
        }
    }

    override fun initObserver() {
        viewModel.apply {

        }
    }

}