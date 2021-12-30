package com.example.lyricsnake.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lyricsnake.R
import com.example.lyricsnake.databinding.CardPersonBinding
import com.example.lyricsnake.model.PersonModel

class PersonListAdapter(
    private val onClickListener:(PersonModel) -> Unit
) : ListAdapter<PersonModel, PersonListAdapter.PersonListAdapterViewHolder>(DIFF_CALLBACK){

    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):PersonListAdapterViewHolder =
        PersonListAdapterViewHolder(
           CardPersonBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )

    override fun onBindViewHolder(holder: PersonListAdapterViewHolder, position: Int) =
        holder.bind(getItem(position),onClickListener)

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PersonModel>(){
            override fun areItemsTheSame(oldItem: PersonModel, newItem: PersonModel): Boolean =
                oldItem.firstName == newItem.firstName

            override fun areContentsTheSame(oldItem: PersonModel, newItem: PersonModel): Boolean =
                oldItem == newItem
        }
    }

    class PersonListAdapterViewHolder(private val binding : CardPersonBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(
            model: PersonModel,
            onClickListener: (PersonModel) -> Unit
            ){
            binding.tvFirstName.text = model.firstName
            binding.tvLastName.text = model.lastName
            binding.tvAge.text = model.age
            binding.cv.setOnClickListener{onClickListener(model)}
        }
    }
}

