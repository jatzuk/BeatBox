package com.example.jatzuk.beatbox

import android.content.Context
import android.content.res.AssetManager
import android.media.AudioAttributes
import android.media.SoundPool
import android.util.Log
import java.io.IOException

open class BeatBox(context: Context) {
    private val assets: AssetManager = context.assets
    private val audioAttributes = AudioAttributes.Builder().setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
        .setUsage(AudioAttributes.USAGE_MEDIA).build()
    private val soundPool = SoundPool.Builder().setAudioAttributes(audioAttributes).setMaxStreams(MAX_SOUNDS).build()
    val sounds = ArrayList<Sound>()
    var playbackSpeed = 1.0F

    init {
        loadSounds()
    }

    @Throws(IOException::class)
    private fun loadSounds() {
        try {
            val soundNames = assets.list(SOUNDS_FOLDER) ?: throw IOException()
            Log.i(TAG, "Found ${soundNames.size} sounds")

            for (filename in soundNames) {
                with(Sound("$SOUNDS_FOLDER/$filename")) {
                    load(this)
                    sounds.add(this)
                }
            }
        } catch (e: IOException) {
            Log.e(TAG, "Could not list assets", e)
            return
        }
    }

    @Throws(IOException::class)
    private fun load(sound: Sound) {
        sound.soundId = soundPool.load(assets.openFd(sound.assetPath), 1)
    }

    fun play(sound: Sound) {
        soundPool.play(sound.soundId ?: return, 1.0f, 1.0f, 1, 0, playbackSpeed)
    }

    fun release() {
        soundPool.release()
    }

    companion object {
        private const val TAG = "BeatBox"
        private const val SOUNDS_FOLDER = "sample_sounds"
        private const val MAX_SOUNDS = 5
    }
}