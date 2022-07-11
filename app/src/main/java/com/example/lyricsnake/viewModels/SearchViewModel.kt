package com.example.lyricsnake.viewModels

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.lyricsnake.model.PrimaryArtist
import com.example.lyricsnake.model.SearchResponse
import com.example.lyricsnake.repository.local.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRepository: SearchRepository
) : BaseViewModel() {

    var searchList = MutableLiveData<List<PrimaryArtist>>()

    fun search(searchText: String) {
        compositeDisposable += searchRepository.search(searchText)
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

    private fun prepareDataForAdapter(searchResponse: SearchResponse) {
        val list = mutableListOf<PrimaryArtist>()
        searchResponse.response.hits.forEach {
            val primaryArtist = it.result.primaryArtist
            val exist = list.firstOrNull { it.id == primaryArtist.id }
            if (exist == null) {
                list.add(primaryArtist)
            }
        }

        searchList.value = list
    }


}