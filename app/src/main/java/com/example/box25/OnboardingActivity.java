/*
 * Source: https://github.com/tutsplus/Android-Onboarding/blob/master/app/src/main/java/com/hathy/onboardingtutorial/OnboardingActivity.java
 * https://developer.android.com/training/animation/screen-slide-2
 * */

package com.example.box25;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

public class OnboardingActivity extends FragmentActivity {

    private static final int NUM_OF_PAGES = 5;

    private ViewPager2 viewPager;

    private FragmentStateAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        viewPager = findViewById(R.id.view_pager);
        pagerAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
        }
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

    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        public ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            if (position == 0) {
                return new OnboardingScreen1Fragment();
            } else if (position == 1) {
                return new OnboardingScreen2Fragment();
            } else {
                return new OnboardingScreen3Fragment();
            }

        }

        @Override
        public int getItemCount() {
            return NUM_OF_PAGES;
        }
    }
}