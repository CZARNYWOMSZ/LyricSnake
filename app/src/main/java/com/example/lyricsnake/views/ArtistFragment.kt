package com.example.lyricsnake.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.lyricsnake.databinding.FragmentArtistBinding
import com.example.lyricsnake.repository.local.ArtistRepository
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@AndroidEntryPoint
class ArtistFragment : Fragment() {

    @Inject
    lateinit var artistRepository : ArtistRepository
    private var _binding: FragmentArtistBinding? = null
    private val binding get() = _binding!!
    private val compositeDisposable = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArtistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArtist(2424)

    }

    fun getArtist (artistId: Int) {
        compositeDisposable += artistRepository.getArtist(artistId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                       it?.let {
//                           val name = it.response.artist.name
//                           binding.tvArtistNameValue.text = name
//                           binding.tvArtistNameValue.visibility = View.VISIBLE
//                           binding.tvArtistNameLabel.visibility = View.VISIBLE
//                           val instagramName = it.response.artist.instagramName
//                           binding.tvArtistIgNameValue.text = instagramName
//                           binding.tvArtistIgNameValue.visibility = View.VISIBLE
//                           binding.tvArtistIgNameLabel.visibility = View.VISIBLE
                       }
            },{
                Toast.makeText(context, "${it.message}", Toast.LENGTH_LONG).show()
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        if (!compositeDisposable.isDisposed) compositeDisposable.dispose()
    }
}