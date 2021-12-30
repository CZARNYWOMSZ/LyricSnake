package com.example.lyricsnake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lyricsnake.databinding.FragmentVideoBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem


class VideoFragment: Fragment() {
    private var _binding: FragmentVideoBinding? = null
    private val binding get() = _binding!!
    private var player: ExoPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVideoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        player = context?.let {
            ExoPlayer.Builder(it).build()
        }
        player?.let {

            binding.playerView.player = it

            val mediaItem: MediaItem = MediaItem.fromUri("http://techslides.com/demos/sample-videos/small.mp4")
            it.setMediaItem(mediaItem)
            it.prepare()
            it.play()
        }

    }

    override fun onDestroyView() {
        player?.release()
        super.onDestroyView()
        _binding = null
    }
}