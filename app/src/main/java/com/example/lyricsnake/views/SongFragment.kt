package com.example.lyricsnake.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.lyricsnake.R
import com.example.lyricsnake.adapter.SongListAdapter
import com.example.lyricsnake.databinding.FragmentArtistPageBinding
import com.example.lyricsnake.databinding.FragmentSongBinding
import com.example.lyricsnake.model.Song
import com.example.lyricsnake.repository.local.ArtistRepository
import com.example.lyricsnake.repository.local.SongRepository
import com.example.lyricsnake.viewModels.SearchViewModel
import com.example.lyricsnake.viewModels.SongViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@AndroidEntryPoint
class SongFragment : Fragment() {

    @Inject
    lateinit var artistRepository: ArtistRepository
    lateinit var songRepository:SongRepository
    private var _binding: FragmentSongBinding? = null
    private val binding get() = _binding!!
    private val compositeDisposable = CompositeDisposable()
    private val viewModel: SongViewModel by viewModels()
    private val songListAdapter: SongListAdapter by lazy {
        SongListAdapter { model: Song ->
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSongBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val artistId = navArgs<SongFragmentArgs>().value.id
        getSong(artistId)

        binding.rvSongList.adapter = songListAdapter
        initViewModel()
    }

    private fun initViewModel () {
        with(viewModel){
            songList.observe(viewLifecycleOwner,{
                it?.let { songListAdapter.submitList(it) }//populate data tu napisz
            })
            isError.observe(viewLifecycleOwner,{
                it?.let {
                    Toast.makeText(context, "${it.message}", Toast.LENGTH_LONG).show()
                }
            })
        }
    }

    private fun getSong(artistId: Int) {
        compositeDisposable += songRepository.getSongs(artistId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let {
                    with(binding) {
                        songContent.visibility = View.VISIBLE
                        loadingScreen.visibility = View.GONE
                    }
                }
            }, {
                Toast.makeText(context, "${it.message}", Toast.LENGTH_LONG).show()
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        if (!compositeDisposable.isDisposed) compositeDisposable.dispose()
    }
}