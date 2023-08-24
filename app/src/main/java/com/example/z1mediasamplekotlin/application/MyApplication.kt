package com.example.z1mediasamplekotlin.application

import android.app.Application
import android.content.Context
import com.example.z1mediasamplekotlin.BuildConfig
import com.z1media.android.sdk.Z1AppOpenAd
import com.z1media.android.sdk.listeners.Z1AppOpenI
import com.z1media.android.sdk.manager.Z1MediaManager
import com.z1media.android.sdk.models.Z1AdError

class MyApplication : Application() {

    var appOpenAd: Z1AppOpenAd?= null
    val IRON_SOURCE_APP_KEY :String="85460dcd"

    override fun onCreate() {
        super.onCreate()

    appOpenAd = Z1AppOpenAd.Builder(this)
        .setTagName("in-app-sample-ap-Z1")
        .setEnvironment(BuildConfig.BUILD_TYPE)
        .setListener(object : Z1AppOpenI {
            override fun onAdLoaded() {

            }

            override fun onAdFailedToLoad(adError: Z1AdError?) {

            }

            override fun onAdDismissedFullScreenContent() {

            }

            override fun onAdShowedFullScreenContent() {

            }

            override fun onAdFailedToShowFullScreenContent(adError: Z1AdError?) {

            }

        }).build()

    }

    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)

        // if using MultiDexApplication not required Z1MediaManager.initMultiDex function
        Z1MediaManager.initMultiDex(this)
    }
}

