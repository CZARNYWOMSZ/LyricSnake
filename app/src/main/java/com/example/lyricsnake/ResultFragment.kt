package com.example.lyricsnake

import android.R
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.lyricsnake.databinding.CardPersonBinding
import com.example.lyricsnake.databinding.FragmentResultBinding
import com.example.lyricsnake.databinding.FragmentSecondBinding
import com.example.lyricsnake.model.FormModel
import com.example.lyricsnake.model.FrogModel


class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val speciesName = navArgs<ResultFragmentArgs>().value.speciesName
        val colour = navArgs<ResultFragmentArgs>().value.colour
        val frog = navArgs<ResultFragmentArgs>().value.frog

        var text = ""
        text += "Spieces: ${speciesName}\n"
        text += "Colour: ${colour}\n"
        text += "Frog?: ${frog}"
        binding.tvResult.text = text
    }



    private fun createSpecies(speciesName: String, colour: String, frog: String): FrogModel {
        return FrogModel(speciesName, colour, frog)
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}