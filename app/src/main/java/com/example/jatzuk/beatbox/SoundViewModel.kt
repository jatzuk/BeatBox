package com.example.jatzuk.beatbox

import android.databinding.BaseObservable
import android.databinding.Bindable
import java.lang.IllegalArgumentException

class SoundViewModel(private val beatBox: BeatBox) : BaseObservable() {
    var sound: Sound? = null
        set(value) {
            field = value ?: throw IllegalArgumentException("param sound cannot assign null")
            notifyChange()
        }

    @Bindable
    fun getTitle() = sound?.name

    fun onButtonClicked() {
        beatBox.play(sound!!)
    }
}