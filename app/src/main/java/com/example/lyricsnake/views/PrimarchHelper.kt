package com.example.lyricsnake.views

import com.example.lyricsnake.HERETIC
import com.example.lyricsnake.LOYALIST
import com.example.lyricsnake.R
import com.example.lyricsnake.model.ArtistModel
import javax.inject.Inject


class PrimarchHelper @Inject constructor() {
     fun createPrimarchList(): List<ArtistModel> {
        val list = mutableListOf<ArtistModel>()
        list.add(
            ArtistModel(
                "Corvus Corax",
                "Raven Guard",
                "IX",
                R.drawable.corvus_corax,
                LOYALIST
            )
        )
        list.add(
            ArtistModel(
                "Conrad Curze",
                "Night Lords",
                "VIII",
                R.drawable.konrad_curze,
                HERETIC

            )
        )
        list.add(
            ArtistModel(
                "Jaghatai Khan",
                "White Scars",
                "V",
                R.drawable.jaghatai_khan,
                LOYALIST
            )
        )
        list.add(
            ArtistModel(
                "Fulgrim",
                "Emperors Children",
                "VII",
                R.drawable.fulgrim,
                HERETIC
            )
        )

        return list
    }
}