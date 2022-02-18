package com.example.lyricsnake

import android.R
import android.content.Context
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


class PrimarchResultFragment : Fragment() {

    private var _binding: FragmentPrimarchResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPrimarchResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = navArgs<PrimarchResultFragmentArgs>().value.name
        val hisChapter = navArgs<PrimarchResultFragmentArgs>().value.hisChapter
        val hisChaptersNumber = navArgs<PrimarchResultFragmentArgs>().value.hisChaptersNumber
        val image = navArgs<PrimarchResultFragmentArgs>().value.image


        var text = ""
        text += "Primarchs Name: ${name}\n"
        text += "${name}'s Astartes Chapter: ${hisChapter}\n"
        text += "it's number: ${hisChaptersNumber}"
        binding.tvPrimarchResult.text = text
        context?.let {
            binding.ivPrimarchImage.setImageDrawable(ContextCompat.getDrawable(it,image))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}