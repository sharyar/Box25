package com.example.box25

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_onboarding.*

/**
 *
 * Sources: https://www.youtube.com/watch?v=-wB_JE_PRTo&t=54s
 * Sources: https://github.com/ongakuer/CircleIndicator
 */
class OnBoardingActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_onboarding)


        val image = listOf(
                R.drawable.check_logo,
                R.drawable.tomato_1,
                R.drawable.mdi_directions_run
        )

        val title = listOf(
                R.string.welcome_title_1_onboarding,
                R.string.welcome_title_2_onboarding,
                R.string.welcome_title_3_onboarding
        )

        val texts = listOf(
                R.string.welcome_text_1_onboarding,
                R.string.welcome_text_2_onboarding,
                R.string.welcome_text_3_onboarding
        )

        val adapter = ViewPagerAdapter(image, title, texts)
        intro_pager_updated.adapter = adapter

        indicator.setViewPager(intro_pager_updated)
    }
}