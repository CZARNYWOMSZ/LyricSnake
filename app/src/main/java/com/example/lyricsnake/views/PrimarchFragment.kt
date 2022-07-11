package com.example.lyricsnake.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lyricsnake.adapter.PrimarchListAdapter
import com.example.lyricsnake.databinding.FragmentPrimarchBinding
import com.example.lyricsnake.model.ArtistModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PrimarchFragment : Fragment() {

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

        val primarchListAdapter = PrimarchListAdapter { model: ArtistModel ->
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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}