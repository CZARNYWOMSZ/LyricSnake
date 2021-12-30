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
import com.example.lyricsnake.databinding.FragmentSecondBinding
import com.example.lyricsnake.model.FormModel


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val age = navArgs<SecondFragmentArgs>().value.age
        val lastName = navArgs<SecondFragmentArgs>().value.lastName
        val firstName = navArgs<SecondFragmentArgs>().value.firstName

        var text = ""
        text += "Name: ${lastName}\n"
        text += "Age: ${age}\n"
        text += "Eye colour: ${firstName}"
        binding.tvResult.text = text
    }



    private fun createForm(name: String, age: String, eyeColour: String): FormModel {
        return FormModel(name, age, eyeColour)
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}