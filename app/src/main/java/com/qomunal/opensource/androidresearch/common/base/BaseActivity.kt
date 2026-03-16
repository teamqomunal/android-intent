package com.qomunal.opensource.androidresearch.common.base

import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * Created by faisalamircs on 12/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    abstract fun setupViewBinding(): VB

    abstract fun initObserver()
    abstract fun initUI()

    open fun setupOnActivityResult(result: ActivityResult) {}

    val startActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        setupOnActivityResult(it)
    }
    
    protected val binding by lazy { setupViewBinding() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initUI()
        initObserver()
    }

}