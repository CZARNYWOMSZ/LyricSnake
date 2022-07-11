package com.example.lyricsnake.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.lyricsnake.R
import com.example.lyricsnake.adapter.ArtistListAdapter
import com.example.lyricsnake.adapter.SongListAdapter
import com.example.lyricsnake.databinding.FragmentArtistPageBinding
import com.example.lyricsnake.model.PrimaryArtist
import com.example.lyricsnake.model.Song
import com.example.lyricsnake.repository.local.ArtistRepository
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@AndroidEntryPoint
class ArtistPageFragment : Fragment() {

    @Inject
    lateinit var artistRepository: ArtistRepository
    private var _binding: FragmentArtistPageBinding? = null
    private val binding get() = _binding!!
    private val compositeDisposable = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArtistPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val artistId = navArgs<ArtistPageFragmentArgs>().value.id

        binding.btnShowSongs.setOnClickListener {
            findNavController().navigate(
                ArtistPageFragmentDirections.actionArtistPageFragmentToSongFragment(
                    artistId
                )
            )
        }


        getArtist(artistId)
    }

    private fun getArtist(artistId: Int) {
        compositeDisposable += artistRepository.getArtist(artistId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let {
                    with(binding) {
                        tvNameOfTheArtist.text = it.response.artist.name
                        tvArtistFacebookName.text = it.response.artist.facebookName
                        tvArtistInstagramName.text = it.response.artist.instagramName
                        val bandImage = it.response.artist.imageUrl
                        context?.let {Glide.with(it).load(bandImage).into(binding.ivBandsImage) }
                        artistPageContent.visibility = View.VISIBLE
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