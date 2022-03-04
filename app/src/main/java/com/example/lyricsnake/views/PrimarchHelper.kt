package com.example.lyricsnake.views

import com.example.lyricsnake.HERETIC
import com.example.lyricsnake.LOYALIST
import com.example.lyricsnake.R
import com.example.lyricsnake.model.PrimarchModel
import javax.inject.Inject


class PrimarchHelper @Inject constructor() {
     fun createPrimarchList(): List<PrimarchModel> {
        val list = mutableListOf<PrimarchModel>()
        list.add(
            PrimarchModel(
                "Corvus Corax",
                "Raven Guard",
                "IX",
                R.drawable.corvus_corax,
                LOYALIST
            )
        )
        list.add(
            PrimarchModel(
                "Conrad Curze",
                "Night Lords",
                "VIII",
                R.drawable.konrad_curze,
                HERETIC

            )
        )
        list.add(
            PrimarchModel(
                "Jaghatai Khan",
                "White Scars",
                "V",
                R.drawable.jaghatai_khan,
                LOYALIST
            )
        )
        list.add(
            PrimarchModel(
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