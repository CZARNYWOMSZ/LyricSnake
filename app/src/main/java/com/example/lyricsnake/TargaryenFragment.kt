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
import com.example.lyricsnake.adapter.TargaryenListAdapter
import com.example.lyricsnake.databinding.FragmentAnimalsCardBinding
import com.example.lyricsnake.databinding.FragmentCardBinding
import com.example.lyricsnake.databinding.FragmentListBinding
import com.example.lyricsnake.databinding.FragmentTargaryenBinding
import com.example.lyricsnake.model.FrogModel
import com.example.lyricsnake.model.TargaryenModel

class TargaryenFragment : Fragment() {

    private var _binding: FragmentTargaryenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTargaryenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val TargaryenListAdapter = TargaryenListAdapter { model: TargaryenModel ->
            findNavController().navigate(
                TargaryenFragmentDirections.actionTargaryenFragmentToTargaryenResultFragment(
                    model.name,
                    model.alias,
                    model.yearBornIn,
                    model.yearDiedIn,
                    model.words,
                    model.hisDragonsName,
                    model.yearsRuled,
                    model.hairColour,
                    model.eyeColour,
                    model.image,
                    model.description
                )
            )
        }
        binding.rvTargaryen.adapter = TargaryenListAdapter
        TargaryenListAdapter.submitList(createTargaryenList())
    }

    private fun createTargaryenList(): List<TargaryenModel> {
        val list = mutableListOf<TargaryenModel>()
        list.add(
            TargaryenModel(
                "Aegon the first",
                "the Conqueror",
                "27 B.C",
                "37 A.C",
                "Fire and Blood",
                "Balerion",
                "36",
                "Silver",
                "purple",
                R.drawable.aegon_the_conqueror,
            ""
            )
        )

        list.add(
            TargaryenModel(
                "Aerys the second",
                "the Mad King",
                "244 A.C",
                "283 A.C",
                "Fire and Blood",
                "He had none",
                "21",
                "Silver",
                "purple",
                 R.drawable.mad_king,
                ""
            )
        )
        list.add(
            TargaryenModel(
                "Viserys the first",
                "the Young King",
                "77 A.C",
                "129 A.C",
                "Fire and Blood",
                "Balerion",
                "26",
                "Silver",
                "purple",
                R.drawable.viserys_the_first,
                ""
            )
        )
        list.add(
            TargaryenModel(
                "Jaehaerys the first",
                "the Consiliator",
                "34 A.C",
                "103 A.C",
                "Fire and Blood",
                "Vermithor`",
                "55",
                "Silver",
                "purple",
                R.drawable.jaehaerys,
                ""
            )
        )
        return list
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}