package com.example.lyricsnake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.lyricsnake.databinding.FragmentListBinding
import com.example.lyricsnake.model.PersonModel

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun createPersonList(): List<PersonModel> {
        val list = mutableListOf<PersonModel>()
        list.add(
            PersonModel(
                "Max",
                "Podbielski",
                "16"
            )
        )

        list.add(
            PersonModel(
                "Maciek",
                "Żuk",
                "30"
            )
        )
        return list
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




