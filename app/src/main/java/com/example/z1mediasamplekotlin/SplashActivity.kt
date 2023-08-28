package com.example.z1mediasamplekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.TextView
import com.example.z1mediasamplekotlin.application.MyApplication
import com.example.z1mediasamplekotlin.databinding.ActivitySplashBinding
import com.z1media.android.sdk.listeners.OnShowAdCompleteListener

class SplashActivity : AppCompatActivity() {

    private val LOG_TAG = "SplashActivity"

    lateinit var binding:ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val handler=Handler(Looper.myLooper()!!)
        handler.postDelayed({
            val application = application as? MyApplication

                // If the application is not an instance of MyApplication, log an error message and
                // start the MainActivity without showing the app open ad.
                if (application == null) {
                    Log.e(LOG_TAG, "Failed to cast application to MyApplication.")
                    startMainActivity()

                }


                application?.appOpenAd?.showAdIfAvailable(this@SplashActivity,
                    object : OnShowAdCompleteListener {
                        override fun onShowAdComplete() {
                            Log.e(LOG_TAG, " onShowAdComplete")
                            startMainActivity()
                        }
                    })
        }, 2000)
    }


    fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}