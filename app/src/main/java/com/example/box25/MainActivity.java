/*
*
*
* Sources: https://developer.android.com/training/tv/playback/onboarding
* */

package com.example.box25;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context;
        SharedPreferences sharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE);

        // This checks if we need to display our on-boarding activity
        if (!sharedPreferences.getBoolean("onboarding_complete", false)) {
            startActivity(new Intent(this, OnboardingActivity.class));

            finish();
        } else {
//            To be implemented
            finish();
        }
    }


}