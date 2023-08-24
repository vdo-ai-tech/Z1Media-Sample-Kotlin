package com.example.z1mediasamplekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.z1mediasamplekotlin.application.MyApplication
import com.example.z1mediasamplekotlin.databinding.ActivityBannerBinding
import com.z1media.android.sdk.Z1BannerAd
import com.z1media.android.sdk.listeners.Z1BannerAdsI
import com.z1media.android.sdk.models.Z1AdError
import com.z1media.android.sdk.utils.Z1AdSize

class BannerActivity : AppCompatActivity() {

    lateinit var binding : ActivityBannerBinding
    val builder = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBannerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bannerAd = Z1BannerAd.Builder(this)
            .setBannerView(binding.bannerAdsContainer)
            .setTagName("in-app-sample-b-Z1")
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setAddSize(Z1AdSize.BANNER)
            .setListener( object : Z1BannerAdsI {
                override fun onAdClicked() {
                    builder.append("Add Clicked \n")
                    binding.textView.text = builder.toString()
                }

                override fun onAdClosed() {
                    builder.append("Add Closed \n")
                    binding.textView.text = builder.toString()
                }

                override fun onAdFailedToLoad(adError: Z1AdError?) {
                    builder.append("Add Fail to load \n")
                    binding.textView.text = builder.toString()
                }

                override fun onAdImpression() {
                    builder.append("Add impression \n")
                    binding.textView.text = builder.toString()
                }

                override fun onAdLoaded() {
                    builder.append("Add loaded \n")
                    binding.textView.text = builder.toString()
                }

                override fun onAdOpened() {
                    builder.append("Add opened \n")
                    binding.textView.text = builder.toString()
                }
            }).build()
        bannerAd.loadBannerAd()

    }

}