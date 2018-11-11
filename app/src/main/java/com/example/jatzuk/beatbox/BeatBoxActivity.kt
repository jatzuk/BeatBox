package com.example.jatzuk.beatbox

import android.support.v4.app.Fragment

class BeatBoxActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment {
        return BeatBoxFragment.newInstance()
    }
}
