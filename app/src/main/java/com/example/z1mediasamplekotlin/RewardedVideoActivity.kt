package com.example.z1mediasamplekotlin


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.z1mediasamplekotlin.application.MyApplication
import com.example.z1mediasamplekotlin.databinding.ActivityRewardedVideoBinding
import com.z1media.android.sdk.Z1RewardedVideoAd
import com.z1media.android.sdk.listeners.Z1RewardedVideoI
import com.z1media.android.sdk.models.Z1AdError

class RewardedVideoActivity : AppCompatActivity() {
    lateinit var  binding: ActivityRewardedVideoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRewardedVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rewardedVideoAd = Z1RewardedVideoAd.Builder(this)
            .setTagName("in-app-sample-rw-Z1")
           .setEnvironment(BuildConfig.BUILD_TYPE)
            .setListener(object : Z1RewardedVideoI {


                override fun onAdLoaded() {

                }

                override fun onAdFailedToLoad(adError: Z1AdError?) {

                }

                override fun onAdImpression() {

                }

                override fun onAdClicked() {

                }

                override fun onAdShowedFullScreenContent() {

                }

                override fun onAdDismissedFullScreenContent() {

                }

                override fun onAdFailedToShowFullScreenContent(adError: Z1AdError?) {

                }



                override fun onUserEarnedReward(amount: Int, type: String) {
                    binding.title.text = "Reward Amount $amount , type: $type"
                }

            }).build()
        rewardedVideoAd.loadRewardVideoAd()
    }
}