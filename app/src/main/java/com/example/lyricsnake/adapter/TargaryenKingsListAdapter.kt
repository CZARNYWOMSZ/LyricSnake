package com.example.lyricsnake.adapter

import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lyricsnake.databinding.CardTargaryenBinding
import com.example.lyricsnake.databinding.FragmentTargaryenResultBinding
import com.example.lyricsnake.model.TargaryenModel

class TargaryenKingsListAdapter : ListAdapter<TargaryenModel, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    private val viewTypeText = 1
    private val viewTypeImage = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            viewTypeText -> TargaryenKingsListAdapterViewHolderText(
                LayoutInflater.from(parent.context)
                    .inflate(,parent,false)
            )
            viewTypeImage -> TargaryenKingsListAdapterViewHolderImage(
                LayoutInflater.from(parent.context)
                    .inflate(LayoutInflater.from(parent.context),parent,false)
            )
            else -> TargaryenKingsListAdapterViewHolderText(
                LayoutInflater.from(parent.context)
                    .inflate(LayoutInflater.from(parent.context),parent,false)
            )
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        if (holder.itemViewType == viewTypeText) {
            (holder as TargaryenKingsListAdapterViewHolderText).bind(getItem(position))
        } else {
            (holder as TargaryenKingsListAdapterViewHolderImage).bind(getItem(position))
        }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TargaryenModel>() {
            override fun areItemsTheSame(oldItem: TargaryenModel, newItem: TargaryenModel): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: TargaryenModel, newItem: TargaryenModel): Boolean =
                oldItem == newItem
        }
    }

    class TargaryenKingsListAdapterViewHolderText(private val binding : FragmentTargaryenResultBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(model: TargaryenModel) {
            itemView.apply {
                binding.tvTargaryenDescription.text = model.name
            }
        }
    }

    class TargaryenKingsListAdapterViewHolderImage(private val binding : FragmentTargaryenResultBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(model: TargaryenModel) {
            itemView.apply {
                binding.ivTargaryenImage.baseline = model.image
            }
        }
    }
}
