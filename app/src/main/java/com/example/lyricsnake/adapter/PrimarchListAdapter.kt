package com.example.lyricsnake.adapter

import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lyricsnake.LOYALIST
import com.example.lyricsnake.databinding.CardHereticBinding
import com.example.lyricsnake.databinding.CardLoyalistBinding
import com.example.lyricsnake.model.PrimarchModel

class PrimarchListAdapter(
    private val onClickListener:(PrimarchModel) -> Unit
) : ListAdapter<PrimarchModel, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    private val viewTypeLoyalist = 1
    private val viewTypeHeretic = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            viewTypeLoyalist -> PrimarchLoyalistListAdapterViewHolder(
                CardLoyalistBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            )
            viewTypeHeretic -> PrimarchHereticListAdapterViewHolder(
                CardHereticBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            )
            else -> PrimarchLoyalistListAdapterViewHolder(
                CardLoyalistBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            )
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        if (holder.itemViewType == viewTypeLoyalist) {
            (holder as PrimarchLoyalistListAdapterViewHolder).bind(getItem(position),onClickListener)
        } else {
            (holder as PrimarchHereticListAdapterViewHolder).bind(getItem(position),onClickListener)
        }

    override fun getItemViewType(position: Int): Int =
        if (getItem(position).alligence == LOYALIST) viewTypeLoyalist else viewTypeHeretic

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PrimarchModel>() {
            override fun areItemsTheSame(oldItem: PrimarchModel, newItem: PrimarchModel): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: PrimarchModel, newItem: PrimarchModel): Boolean =
                oldItem == newItem
        }
    }

    class PrimarchLoyalistListAdapterViewHolder(private val binding : CardLoyalistBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(
            model: PrimarchModel,
            onClickListener: (PrimarchModel) -> Unit
        ){
            binding.tvPrimarchName.text = model.name
            binding.tvPrimarchChapter.text = model.hisChapter
            binding.cvPrimarch.setOnClickListener{onClickListener(model)}
        }
    }

    class PrimarchHereticListAdapterViewHolder(private val binding : CardHereticBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(
            model: PrimarchModel,
            onClickListener: (PrimarchModel) -> Unit
        ){
            binding.tvPrimarchName.text = model.name
            binding.tvPrimarchChapter.text = model.hisChapter
            binding.cvPrimarch.setOnClickListener{onClickListener(model)}
        }
    }
}