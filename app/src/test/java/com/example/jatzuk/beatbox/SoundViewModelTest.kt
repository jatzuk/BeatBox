package com.example.jatzuk.beatbox

import org.hamcrest.core.Is.`is`
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

open class SoundViewModelTest {
    private lateinit var beatBox: BeatBox
    private lateinit var sound: Sound
    private lateinit var subject: SoundViewModel

    @Before
    @Throws(Exception::class)
    fun setUp() {
        beatBox = mock(BeatBox::class.java)
        subject = SoundViewModel(beatBox)
        sound = Sound("assetPath")
        subject.sound = sound
    }

    @Test
    fun exposesSoundNameAsTitle() {
        assertThat(subject.getTitle(), `is`(sound.name))
    }

    @Test
    fun test() {
        assertEquals(subject.getTitle(), sound.name)
    }

    @Test
    fun callsBeatBoxPlayOnButtonClicked() {
        subject.onButtonClicked()
        verify(beatBox).play(sound)
    }
}