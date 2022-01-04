package com.example.lyricsnake.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lyricsnake.databinding.CardTargaryenBinding
import com.example.lyricsnake.model.TargaryenModel

class TargaryenListAdapter(
    private val onClickListener:(TargaryenModel) -> Unit
) : ListAdapter<TargaryenModel, TargaryenListAdapter.TargaryenListAdapterViewHolder>(DIFF_CALLBACK){

    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):TargaryenListAdapterViewHolder =
        TargaryenListAdapterViewHolder(
            CardTargaryenBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )

    override fun onBindViewHolder(holder: TargaryenListAdapterViewHolder, position: Int) =
        holder.bind(getItem(position),onClickListener)

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TargaryenModel>(){
            override fun areItemsTheSame(oldItem: TargaryenModel, newItem: TargaryenModel): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: TargaryenModel, newItem: TargaryenModel): Boolean =
                oldItem == newItem
        }
    }

    class TargaryenListAdapterViewHolder(private val binding : CardTargaryenBinding) : RecyclerView.ViewHolder(binding.root){
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