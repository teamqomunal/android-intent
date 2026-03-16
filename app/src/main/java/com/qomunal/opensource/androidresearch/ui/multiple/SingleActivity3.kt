package com.qomunal.opensource.androidresearch.ui.multiple

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.qomunal.opensource.androidresearch.common.base.BaseActivity
import com.qomunal.opensource.androidresearch.databinding.ActivitySingleBinding
import com.qomunal.opensource.androidresearch.ui.detail.DetailViewModel
import com.qomunal.opensource.androidresearch.util.Constant.EXTRA_TEXT

class SingleActivity3 : BaseActivity<ActivitySingleBinding>() {

    companion object {

        const val RESULT_CODE = 9003

        fun createIntent(context: Context): Intent {
            return Intent(context, SingleActivity3::class.java).apply {

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

    override fun setupViewBinding(): ActivitySingleBinding {
        return ActivitySingleBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initUI() {
        binding.apply {
            tvTitle.text = "Single 3"
            btnTest.text = "Finish"

            btnTest.setOnClickListener {
                setResult(SingleActivity2.RESULT_CODE, Intent().apply {
                    putExtra(EXTRA_TEXT, "From Single 3")
                })
                finish()
            }

            btnBack.setOnClickListener {
                setResult(SingleActivity2.RESULT_CODE, Intent().apply {
                    putExtra(EXTRA_TEXT, "From Single 3")
                })
                finish()
            }
        }
    }

    override fun initObserver() {
        viewModel.apply {

        }
    }

}