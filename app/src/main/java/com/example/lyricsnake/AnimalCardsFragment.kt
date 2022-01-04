package com.example.lyricsnake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.lyricsnake.adapter.AnimalListAdapter
import com.example.lyricsnake.adapter.FrogListAdapter
import com.example.lyricsnake.adapter.PersonListAdapter
import com.example.lyricsnake.databinding.FragmentAnimalsCardBinding
import com.example.lyricsnake.databinding.FragmentCardBinding
import com.example.lyricsnake.databinding.FragmentListBinding
import com.example.lyricsnake.model.FrogModel

class AnimalCardsFragment : Fragment() {

    private var _binding: FragmentAnimalsCardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimalsCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val AnimalListAdapter = AnimalListAdapter { model: FrogModel ->
            findNavController().navigate(
                AnimalCardsFragmentDirections.actionAnimalCardsFragmentToAnimalCardsResultFragment(
                    model.spiecesName, model.colour, model.frog
                )
            )
        }
        binding.rv.adapter = AnimalListAdapter
        AnimalListAdapter.submitList(createFrogList())
    }

    private fun createFrogList(): List<FrogModel> {
        val list = mutableListOf<FrogModel>()
        list.add(
            FrogModel(
                "Frog",
                "Green",
                "yes"
            )
        )

        list.add(
            FrogModel(
                "Dragon",
                "Black",
                "no"
            )
        )
        return list
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
