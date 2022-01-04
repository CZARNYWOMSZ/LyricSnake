package com.example.lyricsnake.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lyricsnake.databinding.AnimalsCardBinding
import com.example.lyricsnake.model.FrogModel

class AnimalListAdapter(
    private val onClickListener:(FrogModel) -> Unit
) : ListAdapter<FrogModel, AnimalListAdapter.AnimalListAdapterViewHolder>(DIFF_CALLBACK){

    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):AnimalListAdapterViewHolder =
        AnimalListAdapterViewHolder(
            AnimalsCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )

    override fun onBindViewHolder(holder: AnimalListAdapterViewHolder, position: Int) =
        holder.bind(getItem(position),onClickListener)

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FrogModel>(){
            override fun areItemsTheSame(oldItem: FrogModel, newItem: FrogModel): Boolean =
                oldItem.spiecesName == newItem.spiecesName

            override fun areContentsTheSame(oldItem: FrogModel, newItem: FrogModel): Boolean =
                oldItem == newItem
        }
    }

    class AnimalListAdapterViewHolder(private val binding : AnimalsCardBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(
            model: FrogModel,
            onClickListener: (FrogModel) -> Unit
        ){
            binding.tvAnimalName.text = model.spiecesName
            binding.blackLine
            binding.acv.setOnClickListener{onClickListener(model)}
        }
    }
}