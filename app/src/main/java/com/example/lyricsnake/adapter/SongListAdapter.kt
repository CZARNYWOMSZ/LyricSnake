package com.example.lyricsnake.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lyricsnake.databinding.CardSongBinding
import com.example.lyricsnake.model.Song

class SongListAdapter(
    private val onClickListener: (Song) -> Unit
) : ListAdapter<Song, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        SongListAdapterViewHolder(
            CardSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        (holder as SongListAdapterViewHolder).bind(getItem(position), onClickListener)

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Song>() {
            override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean =
                oldItem == newItem
        }
    }

    class SongListAdapterViewHolder(private val binding: CardSongBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            model: Song,
            onClickListener: (Song) -> Unit
        ) {
            binding.tvSongName.text = model.title
            binding.cvSong.setOnClickListener { onClickListener(model) }
        }
    }
}