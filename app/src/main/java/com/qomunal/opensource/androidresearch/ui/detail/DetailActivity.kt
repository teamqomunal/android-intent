package com.qomunal.opensource.androidresearch.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.qomunal.opensource.androidresearch.common.base.BaseActivity
import com.qomunal.opensource.androidresearch.common.ext.getIntentExtraExt
import com.qomunal.opensource.androidresearch.databinding.ActivityDetailBinding

/**
 * Created by faisalamircs on 13/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    companion object {
        const val TEXT_KEY_EXTRA = "TEXT_KEY_EXTRA"

        fun createIntent(context: Context, text: String): Intent {
            return Intent(context, DetailActivity::class.java).apply {
                putExtra(TEXT_KEY_EXTRA, text)
            }
        }

        fun launch(activity: AppCompatActivity, text: String) {
            activity.startActivity(createIntent(activity, text))
        }

    }

    private val viewModel: DetailViewModel by viewModels()

    private val router: DetailRouter by lazy {
        DetailRouter(this)
    }

    private val extra : String? by lazy {
        getIntentExtraExt(TEXT_KEY_EXTRA)
    }

    override fun setupViewBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initUI() {
        binding.apply {
            tvText.text = extra
        }
    }

    override fun initObserver() {
        viewModel.apply {

        }
    }

}