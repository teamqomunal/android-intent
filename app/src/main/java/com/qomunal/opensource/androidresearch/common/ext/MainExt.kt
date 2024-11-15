package com.qomunal.opensource.androidresearch.common.ext

/**
 * Created by faisalamircs on 13/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity


inline fun <reified T> AppCompatActivity.getIntentExtraExt(params: String): T? {
    if (intent.hasExtra(params)) {
        val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(
                params,
                T::class.java
            )
        } else {
            @Suppress("DEPRECATION") intent.getParcelableExtra(params)
        }
        return data
    }
    return null
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

fun FragmentActivity.startActivityIntentToOtherApp(uri: String) {
    val newUri = if (uri.contains("http://") || uri.contains("https://")) {
        uri
    } else {
        "http://$uri"
    }
    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(newUri)))
}

inline fun <reified T> Intent.getResultIntentExtraExt(params: String): T? {
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





