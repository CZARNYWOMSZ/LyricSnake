package com.example.lyricsnake

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lyricsnake.databinding.FragmentFirstBinding
import com.example.lyricsnake.model.FormModel

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnResult.setOnClickListener {
            val form = createForm(
                binding.etName.text.toString(),
                binding.etAge.text.toString(),
                binding.etEyeColour.text.toString()
            )
            var text = ""
            text += "Name: ${form.name}\n"
            text += "Age: ${form.age}\n"
            text +=  "${getString(R.string.what_is_your_eye_colour)} ${form.eyecolour}\n"
            binding.tvResult.text = text
        }
    }



    private fun createForm(name: String, age: String, eyeColour:String): FormModel {

        return FormModel(name, age, eyeColour)
    }

    fun getTextFromEditText(): String {

        return "${binding.etName.text}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}