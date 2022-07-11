package com.example.lyricsnake.viewModels

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.lyricsnake.model.*
import com.example.lyricsnake.repository.local.SongRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class SongViewModel @Inject constructor(
    private val songRepository: SongRepository
) : BaseViewModel() {

    var songList = MutableLiveData<List<Songs>>()

    private fun getSongs(artistId: Int) {
        compositeDisposable += songRepository.getSongs(artistId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let {
                    prepareDataForAdapter(it)
                }
            }, {
                isError.value = it
            })
    }

    private fun prepareDataForAdapter(artistSongsResponse: ArtistSongsResponse) {
        val list = mutableListOf<PrimaryArtist>()
        artistSongsResponse.response.songs.forEach{
            val song = it.songs
            val exist = list.firstOrNull { it.id ==  }
            if (exist == null) {
                list.add(Song)
            }
        }

        songList.value = list
    }


}