package com.example.jatzuk.beatbox

class Sound(val assetPath: String) {
    private val components = assetPath.split("/")
    private val filename = components[components.size - 1]
    val name = filename.replace(".wav", "")
    var soundId: Int? = null
}