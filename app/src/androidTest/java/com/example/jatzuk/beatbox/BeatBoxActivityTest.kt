package com.example.jatzuk.beatbox

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.CoreMatchers.anything
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BeatBoxActivityTest {
    @get:Rule
    var activityTestRule = ActivityTestRule(BeatBoxActivity::class.java)

    @Test
    fun showFirstFileName() {
        onView(withText("65_clipie")).check(matches(anything()))
    }
}
