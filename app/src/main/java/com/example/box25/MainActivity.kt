/*
*
*
* Sources: https://developer.android.com/training/tv/playback/onboarding
* */
package com.example.box25

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)

        // This checks if we need to display our on-boarding activity
        if (!sharedPreferences.getBoolean("onboarding_complete", false)) {
            startActivity(Intent(this, OnBoardingActivity::class.java))
        } else {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }


}