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
import com.qomunal.opensource.androidresearch.ui.main.MainActivity
import com.qomunal.opensource.androidresearch.util.Constant.EXTRA_TEXT

class SingleActivity1 : BaseActivity<ActivitySingleBinding>() {

    companion object {

        const val RESULT_CODE = 9001

        fun createIntent(context: Context): Intent {
            return Intent(context, SingleActivity1::class.java).apply {

            }
        }

        fun launch(activity: AppCompatActivity) {
            activity.startActivity(createIntent(activity))
        }
    }

    private val viewModel: DetailViewModel by viewModels()

    private val router: SingleRouter by lazy {
        SingleRouter(this)
    }

    override fun setupOnActivityResult(result: ActivityResult) {
        super.setupOnActivityResult(result)
        when (result.resultCode) {
            RESULT_CODE -> {
                val text = result.data?.getStringExtra(EXTRA_TEXT)
                binding.tvText.text = text
                setResult(MainActivity.RESULT_CODE, Intent().apply {
                    putExtra(EXTRA_TEXT, "$text and 1")
                })
                finish()
            }
        }
    }

    override fun setupViewBinding(): ActivitySingleBinding {
        return ActivitySingleBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initUI() {
        binding.apply {

            tvTitle.text = "Single 1"

            btnTest.setOnClickListener {
                startActivityResult.launch(router.toSingle2())
            }
        }
    }

    override fun initObserver() {
        viewModel.apply {

        }
    }

}