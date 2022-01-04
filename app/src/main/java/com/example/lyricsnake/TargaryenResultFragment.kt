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
import com.example.lyricsnake.databinding.*
import com.example.lyricsnake.model.FormModel
import com.example.lyricsnake.model.FrogModel
import com.example.lyricsnake.model.TargaryenModel


class TargaryenResultFragment : Fragment() {

    private var _binding: FragmentTargaryenResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTargaryenResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = navArgs<TargaryenResultFragmentArgs>().value.name
        val eyeColour = navArgs<TargaryenResultFragmentArgs>().value.eyeColour
        val hairColour = navArgs<TargaryenResultFragmentArgs>().value.hairColour

        var text = ""
        text += "Kings Name: ${name}\n"
        text += "${name}'s eye colour: ${eyeColour}\n"
        text += "${name}'s hair colour: ${hairColour}"
        binding.tvTargaryenResult.text = text
    }



    private fun createTargaryen(
        name: String,
        alias: String,
        yearBornIn: String,
        yearDiedIn: String,
        hisDragonsName: String,
        words: String,
        yearsRuled: String,
        hairColour: String,
        eyeColour: String): TargaryenModel {
        return TargaryenModel(name, alias, yearBornIn, yearDiedIn, hisDragonsName, words, yearsRuled, hairColour, eyeColour)
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}