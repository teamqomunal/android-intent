package com.qomunal.opensource.androidresearch.common.ext

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by faisalamircs on 13/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


inline fun <reified T> AppCompatActivity.getIntentExtraExt(params: String): T? {
    return intent.getIntentExtraExt(params)
}

inline fun <reified T> Intent.getIntentExtraExt(params: String): T? {
    if (this.hasExtra(params)) {
        val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            this.getParcelableExtra(
                params,
                T::class.java
            )
        } else {
            @Suppress("DEPRECATION") this.getParcelableExtra(params)
        }
        return data
    }
    return null
}