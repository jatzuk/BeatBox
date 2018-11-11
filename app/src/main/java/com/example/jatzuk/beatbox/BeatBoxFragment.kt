package com.example.jatzuk.beatbox

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import com.example.jatzuk.beatbox.databinding.FragmentBeatBoxBinding
import com.example.jatzuk.beatbox.databinding.ListItemSoundBinding
import kotlinx.android.synthetic.main.fragment_beat_box.view.*

class BeatBoxFragment : Fragment() {
    private lateinit var beatBox: BeatBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        beatBox = BeatBox(activity!!)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentBeatBoxBinding>(inflater, R.layout.fragment_beat_box, container, false).root
        with(binding) {
            recycler_view.layoutManager = GridLayoutManager(activity, 3)
            recycler_view.adapter = SoundAdapter(beatBox.sounds)
            text_view.text = getString(R.string.playback_speed, "100")
            seek_bar.progress = binding.seek_bar.max / 2
            seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    val speed = if (progress < seekBar.max / 2) progress * 0.01F + 0.5F else progress * 0.02f
                    beatBox.playbackSpeed = speed
                    text_view.text = getString(R.string.playback_speed, (speed * 100).toInt().toString())
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                }
            })
        }

        return binding
    }

    private inner class SoundAdapter(private val sounds: List<Sound>) : RecyclerView.Adapter<SoundAdapter.SoundHolder>() {
        private inner class SoundHolder(private val binding: ListItemSoundBinding) : RecyclerView.ViewHolder(binding.root) {
            init {
                binding.viewModel = SoundViewModel(beatBox)
            }

            fun bind(sound: Sound) {
                binding.viewModel!!.sound = sound
                binding.executePendingBindings()
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundHolder {
            return SoundHolder(DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.list_item_sound, parent, false))
        }

        override fun getItemCount(): Int {
            return sounds.size
        }

        override fun onBindViewHolder(soundHolder: SoundHolder, position: Int) {
            soundHolder.bind(sounds[position])
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        beatBox.release()
    }

    companion object {
        fun newInstance(): Fragment {
            return BeatBoxFragment()
        }
    }
}