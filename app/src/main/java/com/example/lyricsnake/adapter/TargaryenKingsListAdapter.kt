package com.example.lyricsnake.adapter

import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lyricsnake.MAN
import com.example.lyricsnake.databinding.CardKingBinding
import com.example.lyricsnake.databinding.CardQueenBinding
import com.example.lyricsnake.model.TargaryenModel

class TargaryenKingsListAdapter(
    private val onClickListener:(TargaryenModel) -> Unit
) : ListAdapter<TargaryenModel, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    private val viewTypeKing = 1
    private val viewTypeQueen = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            viewTypeKing -> TargaryenKingsListAdapterKingViewHolder(
                CardKingBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            )
            viewTypeQueen -> TargaryenKingsListAdapterQueenViewHolder(
                CardQueenBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            )
            else -> TargaryenKingsListAdapterKingViewHolder(
                CardKingBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            )
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        if (holder.itemViewType == viewTypeKing) {
            (holder as TargaryenKingsListAdapterKingViewHolder).bind(getItem(position),onClickListener)
        } else {
            (holder as TargaryenKingsListAdapterQueenViewHolder).bind(getItem(position),onClickListener)
        }

    override fun getItemViewType(position: Int): Int =
        if (getItem(position).gender == MAN) viewTypeKing else viewTypeQueen

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TargaryenModel>() {
            override fun areItemsTheSame(oldItem: TargaryenModel, newItem: TargaryenModel): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: TargaryenModel, newItem: TargaryenModel): Boolean =
                oldItem == newItem
        }
    }

    class TargaryenKingsListAdapterKingViewHolder(private val binding : CardKingBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(
            model: TargaryenModel,
            onClickListener: (TargaryenModel) -> Unit
        ){
            binding.tvTargaryenName.text = model.name
            binding.tvTargaryenAlias.text = model.alias
            binding.tvTargaryenWords.text = model.words
            binding.cvTargaryen.setOnClickListener{onClickListener(model)}
        }
    }

    class TargaryenKingsListAdapterQueenViewHolder(private val binding : CardQueenBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(
            model: TargaryenModel,
            onClickListener: (TargaryenModel) -> Unit
        ){
            binding.tvTargaryenName.text = model.name
            binding.tvTargaryenAlias.text = model.alias
            binding.tvTargaryenWords.text = model.words
            binding.cvTargaryen.setOnClickListener{onClickListener(model)}
        }
    }
}
