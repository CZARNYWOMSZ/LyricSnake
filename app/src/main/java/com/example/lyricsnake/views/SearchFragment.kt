package com.example.lyricsnake.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lyricsnake.adapter.ArtistListAdapter
import com.example.lyricsnake.adapter.PrimarchListAdapter
import com.example.lyricsnake.databinding.FragmentSearchBinding
import com.example.lyricsnake.model.ArtistModel
import com.example.lyricsnake.model.PrimaryArtist
import com.example.lyricsnake.model.SearchResponse
import com.example.lyricsnake.repository.local.SearchRepository
import com.example.lyricsnake.viewModels.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import retrofit2.http.Query
import javax.inject.Inject


@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SearchViewModel by viewModels()
    private val artistListAdapter: ArtistListAdapter by lazy {
        ArtistListAdapter { model: PrimaryArtist ->
            findNavController().navigate(
                SearchFragmentDirections.actionSearchFragmentToArtistPageFragment(
                    model.id
                )
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSearch.setOnClickListener {
            val searchText = binding.etSearch.text.toString()
            if (searchText.isNotBlank()) {
                viewModel.search(searchText)
            } else {
                Toast.makeText(context, "please enter text", Toast.LENGTH_LONG).show()
            }
        }

        binding.rvSearchResult.adapter = artistListAdapter
        initViewModel()
    }

    private fun initViewModel () {
        with(viewModel){
            searchList.observe(viewLifecycleOwner,{
                it?.let { artistListAdapter.submitList(it) }//populate data tu napisz
            })
            isError.observe(viewLifecycleOwner,{
                it?.let {
                    Toast.makeText(context, "${it.message}", Toast.LENGTH_LONG).show()
                }
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}