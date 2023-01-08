package com.example.kplist.presentation.search


import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kplist.R
import com.example.kplist.databinding.FragmentBottomSheetBinding
import com.example.kplist.presentation.Constance
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment(private val advancedSearch:(
    nameField: String,
    search: String,
    nameField2: String,
    search2: String,
    sortField: String,
    sortType: String,
    limit: String,
    token: String)->Unit
) : BottomSheetDialogFragment(){

    lateinit var binding : FragmentBottomSheetBinding
    override fun getTheme() = R.style.AppBottomSheetDialogTheme

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomSheetBinding.inflate(inflater, container, false)

        var checkType = Constance.TYPE_MOVIE
        var checkSort = Constance.SORT_BY_YEAR

        binding.textType.text = resources.getString(R.string.movie)
        binding.textGenres.text = resources.getString(R.string.actionMovie)
        binding.textSorted.text = resources.getString(R.string.releaseDate)

        binding.textType.setOnClickListener {
            showAlertDialogSingleType()
        }

        binding.textGenres.setOnClickListener {
            showAlertDialogSingleGenres()
        }

        binding.textSorted.setOnClickListener {
            showAlertDialogSingleSort()
        }

        binding.buttonSearch.setOnClickListener {

            if (binding.textType.text == resources.getString(R.string.movie)) {
                checkType = Constance.TYPE_MOVIE
            }
            if (binding.textType.text == resources.getString(R.string.serials)) {
                checkType = Constance.TYPE_SERIALS
            }
            if (binding.textType.text == resources.getString(R.string.cartoons)) {
                checkType = Constance.TYPE_CARTOONS
            }
            if (binding.textType.text == resources.getString(R.string.anime)) {
                checkType = Constance.TYPE_ANIME
            }
            if (binding.textType.text == resources.getString(R.string.animeSeries)) {
                checkType = Constance.TYPE_ANIME_SERIALS
            }

            if (binding.textSorted.text == resources.getString(R.string.ratingKp)) {
                checkSort = Constance.SORT_BY_KP
            }
            if (binding.textSorted.text == resources.getString(R.string.ratingImdb)) {
                checkSort = Constance.SORT_BY_IMDB
            }
            if (binding.textSorted.text == resources.getString(R.string.releaseDate)) {
                checkSort = Constance.SORT_BY_YEAR
            }

            advancedSearch(
                    Constance.SORT_TYPE,
                    checkType,
                    Constance.SORT_GENRES,
                    binding.textGenres.text as String,
                    checkSort,
                    Constance.FROM_LARGER_TO_SMALLER,
                    Constance.LIMIT,
                    Constance.TOKEN)
            dismiss()

        }

        return binding.root
    }
    private fun showAlertDialogSingleType(){

        val list = arrayOf(
            resources.getString(R.string.movie),
            resources.getString(R.string.serials),
            resources.getString(R.string.cartoons),
            resources.getString(R.string.anime),
            resources.getString(R.string.animeSeries)
        )

        val dialog = AlertDialog.Builder(context,R.style.AlertDialog)
            .setCancelable(true)
            .setIcon(R.drawable.ic_baseline_bathtub_24)
            .setTitle(resources.getString(R.string.selectedType))
            .setSingleChoiceItems(list, -1){dialog, wich ->
                binding.textType.text = list[wich]

                dialog.dismiss()
            }
            .create()

        dialog.show()
    }

    private fun showAlertDialogSingleGenres(){

        val list = arrayOf(
            resources.getString(R.string.biography),
            resources.getString(R.string.actionMovie),
            resources.getString(R.string.western),
            resources.getString(R.string.military),
            resources.getString(R.string.detective),
            resources.getString(R.string.childlike),
            resources.getString(R.string.adults),
            resources.getString(R.string.documentary),
            resources.getString(R.string.drama),
            resources.getString(R.string.game),
            resources.getString(R.string.history),
            resources.getString(R.string.comedy),
            resources.getString(R.string.concert),
            resources.getString(R.string.shortFilm),
            resources.getString(R.string.crime),
            resources.getString(R.string.melodrama),
            resources.getString(R.string.music),
            resources.getString(R.string.musical),
            resources.getString(R.string.news),
            resources.getString(R.string.adventures),
            resources.getString(R.string.realTV),
            resources.getString(R.string.family),
            resources.getString(R.string.sport),
            resources.getString(R.string.talkShows),
            resources.getString(R.string.thriller),
            resources.getString(R.string.horrors),
            resources.getString(R.string.fantastic),
            resources.getString(R.string.filmNoir),
            resources.getString(R.string.fantasy),
            resources.getString(R.string.ceremony),
        )

        val dialog = AlertDialog.Builder(context,R.style.AlertDialog)
            .setCancelable(true)
            .setIcon(R.drawable.ic_baseline_touch_app_24)
            .setTitle(resources.getString(R.string.selectedGenre))
            .setSingleChoiceItems(list, -1){dialog, wich ->
                binding.textGenres.text = list[wich]
                dialog.dismiss()
            }
            .create()

        dialog.show()
    }

    private fun showAlertDialogSingleSort(){

        val list = arrayOf(
            resources.getString(R.string.ratingKp),
            resources.getString(R.string.ratingImdb),
            resources.getString(R.string.releaseDate)
        )

        val dialog = AlertDialog.Builder(context,R.style.AlertDialog)
            .setCancelable(true)
            .setIcon(R.drawable.ic_baseline_pan_tool_alt_24)
            .setTitle(resources.getString(R.string.selectedSort))
            .setSingleChoiceItems(list, -1){dialog, wich ->
                binding.textSorted.text = list[wich]
                dialog.dismiss()
            }
            .create()

        dialog.show()
    }

}