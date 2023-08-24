package com.example.z1mediasamplekotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.z1mediasamplekotlin.databinding.ActivityRewardediBinding
import com.z1media.android.sdk.Z1RewardInterstitialAd
import com.z1media.android.sdk.listeners.Z1RewardInterstitialI
import com.z1media.android.sdk.models.Z1AdError

class RewardedInterstitialActivity : AppCompatActivity() {
    var binding: ActivityRewardediBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRewardediBinding.inflate(
            layoutInflater
        )
        setContentView(binding!!.root)
        val rewardedVideoAd: Z1RewardInterstitialAd = Z1RewardInterstitialAd.Builder(this)
            .setTagName("in-app-sample-rw-Z1")
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setListener(object : Z1RewardInterstitialI {
                override fun onAdImpression() {

                }
                override fun onUserEarnedReward(i: Int, s: String) {

                }
                override fun onAdShowedFullScreenContent() {

                }
                override fun onAdLoaded() {

                }
                override fun onAdFailedToShowFullScreenContent(z1AdError: Z1AdError?) {

                }
                override fun onAdFailedToLoad(z1AdError: Z1AdError?) {

                }
                override fun onAdDismissedFullScreenContent() {

                }
                override fun onAdClicked() {

                }
            }).build()
        rewardedVideoAd.loadRewardInterstitialAd()
    }
}