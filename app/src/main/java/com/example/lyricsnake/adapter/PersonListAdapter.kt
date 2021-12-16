package com.example.lyricsnake.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lyricsnake.R
import com.example.lyricsnake.model.PersonModel

class PersonListAdapter() : ListAdapter<PersonModel, PersonListAdapter.PersonListAdapterViewHolder>(DIFF_CALLBACK){

    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):PersonListAdapterViewHolder =
        PersonListAdapterViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.card_person, parent, false)
        )


    override fun onBindViewHolder(holder: PersonListAdapterViewHolder, position: Int) =
        holder.bind(getItem(position))

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PersonModel>(){
            override fun areItemsTheSame(oldItem: PersonModel, newItem: PersonModel): Boolean =
                oldItem.firstName == newItem.firstName

            override fun areContentsTheSame(oldItem: PersonModel, newItem: PersonModel): Boolean =
                oldItem == newItem
        }
    }

    class PersonListAdapterViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        fun bind(model: PersonModel){
            itemView.apply {
                
            }
        }
    }
}

