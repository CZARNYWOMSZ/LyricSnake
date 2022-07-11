package com.example.lyricsnake.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lyricsnake.databinding.CardArtistBinding
import com.example.lyricsnake.model.PrimaryArtist

class ArtistListAdapter(
    private val onClickListener: (PrimaryArtist) -> Unit
) : ListAdapter<PrimaryArtist, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ArtistListAdapterViewHolder(
            CardArtistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
            (holder as ArtistListAdapterViewHolder).bind(getItem(position), onClickListener)

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PrimaryArtist>() {
            override fun areItemsTheSame(oldItem: PrimaryArtist, newItem: PrimaryArtist): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: PrimaryArtist, newItem: PrimaryArtist): Boolean =
                oldItem == newItem
        }
    }

    class ArtistListAdapterViewHolder(private val binding: CardArtistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            model: PrimaryArtist,
            onClickListener: (PrimaryArtist) -> Unit
        ) {
            binding.tvArtistName.text = model.name
            binding.cvArtist.setOnClickListener { onClickListener(model) }
        }
    }
}