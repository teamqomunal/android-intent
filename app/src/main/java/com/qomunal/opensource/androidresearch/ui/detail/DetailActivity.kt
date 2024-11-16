package com.qomunal.opensource.androidresearch.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import com.qomunal.opensource.androidresearch.common.base.BaseActivity
import com.qomunal.opensource.androidresearch.databinding.ActivityDetailBinding
import com.qomunal.opensource.androidresearch.common.ext.getIntentExtraExt

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
        val TAG = DetailActivity::class.java.name
        const val TEXT_KEY_EXTRA = "TEXT_KEY_EXTRA"
    }

    private val viewModel: DetailViewModel by viewModels()

    private val reouter: DetailRouter by lazy {
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