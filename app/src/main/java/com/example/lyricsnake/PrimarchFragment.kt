package com.example.lyricsnake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lyricsnake.adapter.PrimarchListAdapter
import com.example.lyricsnake.adapter.TargaryenKingsListAdapter
import com.example.lyricsnake.databinding.FragmentPrimarchBinding
import com.example.lyricsnake.databinding.FragmentTargaryenBinding
import com.example.lyricsnake.model.PrimarchModel
import com.example.lyricsnake.model.TargaryenModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PrimarchFragment : Fragment() {

    @Inject
    lateinit var hiltTest: HiltTest
    @Inject
    lateinit var primarchHelper: PrimarchHelper
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
        primarchListAdapter.submitList(primarchHelper.createPrimarchList())
        Toast.makeText(context,hiltTest.getHiltText(), Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}