package com.example.lyricsnake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lyricsnake.adapter.PrimarchListAdapter
import com.example.lyricsnake.adapter.TargaryenKingsListAdapter
import com.example.lyricsnake.databinding.FragmentPrimarchBinding
import com.example.lyricsnake.databinding.FragmentTargaryenBinding
import com.example.lyricsnake.model.PrimarchModel
import com.example.lyricsnake.model.TargaryenModel

class PrimarchFragment : Fragment() {

    private var _binding: FragmentPrimarchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPrimarchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val primarchListAdapter = PrimarchListAdapter { model: PrimarchModel ->
            findNavController().navigate(
                PrimarchFragmentDirections.actionPrimarchFragmentToPrimarchResultFragment(
                    model.name,
                    model.hisChapter,
                    model.hisChaptersNumber,
                    model.image,
                    model.alligence
                )
            )
        }
        binding.rvPrimarch.adapter = primarchListAdapter
        primarchListAdapter.submitList(createPrimarchList())
    }

    private fun createPrimarchList(): List<PrimarchModel> {
        val list = mutableListOf<PrimarchModel>()
        list.add(
            PrimarchModel(
                "Corvus Corax",
                "Raven Guard",
                "IX",
                R.drawable.corvus_corax,
                LOYALIST
            )
        )
        list.add(
            PrimarchModel(
                "Conrad Curze",
                "Night Lords",
                "VIII",
                R.drawable.konrad_curze,
                HERETIC

            )
        )
        list.add(
            PrimarchModel(
                "Jaghatai Khan",
                "White Scars",
                "V",
                R.drawable.jaghatai_khan,
                LOYALIST
            )
        )
        list.add(
            PrimarchModel(
                "Fulgrim",
                "Emperors Children",
                "VII",
                R.drawable.fulgrim,
                HERETIC
            )
        )

        return list
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}