package com.example.lyricsnake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.lyricsnake.adapter.AnimalListAdapter
import com.example.lyricsnake.adapter.FrogListAdapter
import com.example.lyricsnake.adapter.PersonListAdapter
import com.example.lyricsnake.adapter.TargaryenListAdapter
import com.example.lyricsnake.databinding.FragmentAnimalsCardBinding
import com.example.lyricsnake.databinding.FragmentCardBinding
import com.example.lyricsnake.databinding.FragmentListBinding
import com.example.lyricsnake.databinding.FragmentTargaryenBinding
import com.example.lyricsnake.model.FrogModel
import com.example.lyricsnake.model.TargaryenModel

class TargaryenFragment : Fragment() {

    private var _binding: FragmentTargaryenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTargaryenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val TargaryenListAdapter = TargaryenListAdapter { model: TargaryenModel ->
            findNavController().navigate(
                TargaryenFragmentDirections.actionTargaryenFragmentToTargaryenResultFragment(
                    model.name,
                    model.alias,
                    model.yearBornIn,
                    model.yearDiedIn,
                    model.words,
                    model.hisDragonsName,
                    model.yearsRuled,
                    model.hairColour,
                    model.eyeColour,
                    model.image,
                    model.description
                )
            )
        }
        binding.rvTargaryen.adapter = TargaryenListAdapter
        TargaryenListAdapter.submitList(createTargaryenList())
    }

    private fun createTargaryenList(): List<TargaryenModel> {
        val list = mutableListOf<TargaryenModel>()
        list.add(
            TargaryenModel(
                "Aegon the first",
                "the Conqueror",
                "27 B.C",
                "37 A.C",
                "Fire and Blood",
                "Balerion",
                "36",
                "Silver",
                "purple",
                R.drawable.aegon_the_conqueror,
            ""
            )
        )

        list.add(
            TargaryenModel(
                "Aerys the second",
                "the Mad King",
                "244 A.C",
                "283 A.C",
                "Fire and Blood",
                "He had none",
                "21",
                "Silver",
                "purple",
                 R.drawable.mad_king,
                ""
            )
        )
        list.add(
            TargaryenModel(
                "Viserys the first",
                "the Young King",
                "77 A.C",
                "129 A.C",
                "Fire and Blood",
                "Balerion",
                "26",
                "Silver",
                "purple",
                R.drawable.viserys_the_first,
                ""
            )
        )
        list.add(
            TargaryenModel(
                "Jaehaerys the first",
                "the Consiliator",
                "34 A.C",
                "103 A.C",
                "Fire and Blood",
                "Vermithor`",
                "55",
                "Silver",
                "purple",
                R.drawable.jaehaerys,
                "According to a semi-canon source, Jaehaerys had the purple eyes of House Targaryen.[5] At the age of sixteen, he wore his hair loose, flowing about his shoulders.[6] Early in his reign he grew a wispy beard and mustache.[7] By the time he had turned twenty-four, Jaehaerys looked “every inch a king”. He was a tall and handsome man who wore his hair in a thick braid that fell almost to his waist and his facial hair had grown out into a handsome full golden beard, shot through with silver.[7] At an older age, his beard had turned white, and had grown to reach his waist.[5] Even at an old age, Jaehaerys still stood unstooped.[5] By 84 AC, at the age of fifty, Jaehaerys had grown thinner, almost gaunt, and his beard and hair had become more grey than gold.[8] He looked wise and dignified even into his later years.[5]\n" +
                        "\n" +
                        "Jaehaerys moved with an easy grace. It is said that his smile could warm the heart of any maiden, and his frown could make a man's blood run cold.[7] He wore as a crown a simple band of yellow gold ornamented with seven gems of different colors.[9]\n" +
                        "\n" +
                        "Jaehaerys was wise beyond his years.[3][10] He was fair-spoken, open-handed, and as chivalrous as he was courageous.[2] According to Grand Maester Benifer Jaehaerys was \"learned as a maester and pious as a septon\". Although Benifer might have attempted to flatter Jaehaerys with such a statement, according to Archmaester Gyldayn there was some truth to it as well.[2] Queen Alyssa, Jaehaerys's mother, is reported to have called Jaehaerys \"the best of my three sons\".[2]\n" +
                        "\n" +
                        "Jaehaerys was decisive in both thought and deed, and always sought the most peaceable ends.[3] In times of trouble, instead of brooding on the issues, Jaehaerys would shrug off his sorrows and plunge himself into his work.[11][7] He never acted without thinking,[12] and did not trust in chance.[6] Nor did Jaehaerys like to make outright threats, but had other ways of making his disapproval felt. According to the Sealord of Braavos, Jaehaerys was very skillful in making veiled threats.[7]\n" +
                        "\n" +
                        "Even by the age of fourteen, Jaehaerys refused to allow his council to rule the realm in his name during his regency, and would involve himself in many of the issues the small council faced.[2] He was never shy about letting his voice being heard.[10] Nor was he a man who wasted time with reproaches, recriminations, or appeals.[10]\n" +
                        "\n" +
                        "Jaehaerys was a gifted rider.[1] By the time he was fourteen years old, Jaehaerys was already skilled with lance and longbow.[1] Following a rigorous training regime during his time on Dragonstone, he became skilled at arms as well, to the point where Ser Elyas Scales, Jaehaerys's master-at-arms claimed that Jaehaerys would never be skilled enough to join the Kingsguard, but that he had enough skill to beat his uncle Maegor in combat, had Maegor still lived.[12]\n" +
                        "\n" +
                        "Jaehaerys was known for his love of travel,[3] and made many royal progresses. He and Alysanne were known to stay at the inn at the crossroads during their journeys so much so, that afterwards it was renamed the Two Crowns.[3][13]\n" +
                        "\n" +
                        "When he was younger, Jaehaerys had been fascinated by the ponderous tomes and Old Valyrian scrolls found in Dragonstone's library.[11] Jaehaerys had always been close to his sister-wife Alysanne, even as a child, and had always had a strong affection and regard for her.[10]"
            )
        )
        return list
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}