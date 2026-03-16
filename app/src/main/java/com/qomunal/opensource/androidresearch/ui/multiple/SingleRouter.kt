package com.qomunal.opensource.androidresearch.ui.multiple

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.qomunal.opensource.androidresearch.common.base.BaseRouter

/**
 * Created by faisalamircs on 16/03/2026
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


class SingleRouter(private val activity: AppCompatActivity) : BaseRouter(activity) {

    fun toSingle1(): Intent {
        return SingleActivity1.createIntent(activity)
    }

    fun toSingle2(): Intent {
        return SingleActivity2.createIntent(activity)
    }

    fun toSingle3(): Intent {
        return SingleActivity3.createIntent(activity)
    }

}