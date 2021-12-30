package com.example.lyricsnake.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lyricsnake.R
import com.example.lyricsnake.databinding.CardPersonBinding
import com.example.lyricsnake.model.FrogModel
import com.example.lyricsnake.model.PersonModel

class FrogListAdapter(
    private val onClickListener:(FrogModel) -> Unit
) : ListAdapter<FrogModel, FrogListAdapter.FrogListAdapterViewHolder>(DIFF_CALLBACK){

    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):FrogListAdapterViewHolder =
        FrogListAdapterViewHolder(
            CardPersonBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )

    override fun onBindViewHolder(holder: FrogListAdapterViewHolder, position: Int) =
        holder.bind(getItem(position),onClickListener)

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FrogModel>(){
            override fun areItemsTheSame(oldItem: FrogModel, newItem: FrogModel): Boolean =
                oldItem.spiecesName == newItem.spiecesName

            override fun areContentsTheSame(oldItem: FrogModel, newItem: FrogModel): Boolean =
                oldItem == newItem
        }
    }

    class FrogListAdapterViewHolder(private val binding : CardPersonBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(
            model: FrogModel,
            onClickListener: (FrogModel) -> Unit
        ){
            binding.tvFirstName.text = model.spiecesName
            binding.tvLastName.text = model.colour
            binding.tvAge.text = model.frog
            binding.cv.setOnClickListener{onClickListener(model)}
        }
    }
}