/*
 * Source: https://github.com/tutsplus/Android-Onboarding/blob/master/app/src/main/java/com/hathy/onboardingtutorial/OnboardingActivity.java
 * */

package com.example.box25;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class OnboardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
    }


    /**
     * finishes on-boarding operation by changing the user's preference ensuring that this activity
     * will not be launched the next time user starts the application.
     * Also redirects to main activity.
     */
    private void finishOnboarding() {
        SharedPreferences preferences = getSharedPreferences("my_preferences", MODE_PRIVATE);
        preferences.edit().putBoolean("onboarding_complete", true).apply();
        startActivity(new Intent(this, MainActivity.class));
    }
}