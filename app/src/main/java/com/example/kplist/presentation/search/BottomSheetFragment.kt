package com.example.kplist.presentation.search

import android.app.Activity
import android.app.AlertDialog
import android.app.Application
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.kplist.R
import com.example.kplist.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment(){
    lateinit var binding : FragmentBottomSheetBinding
    override fun getTheme() = R.style.AppBottomSheetDialogTheme
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomSheetBinding.inflate(inflater, container, false)

        //binding.textViewHint.text = arguments?.getString("idKey").toString()
        binding.textType.setOnClickListener {
            showAlertDialogSingle()
        }

        binding.textGenres.setOnClickListener {  }

        binding.textSorted.setOnClickListener {  }

        return binding.root
    }
    private fun showAlertDialogSingle(){

        val list = arrayOf("фильмы","сериалы","мультфильмы","аниме","аниме-сериалы")

        val dialog = androidx.appcompat.app.AlertDialog.Builder(context as Activity)
            .setCancelable(true) //если изменить на false, то диалог будет не отменяемым
            .setIcon(R.mipmap.ic_launcher_round)
            .setTitle("Tип:")
            .setSingleChoiceItems(list, -1){dialog, wich ->
                Toast.makeText(context, "Выбранный тип: ${list[wich]}",
                    Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .create()

        dialog.show()
    }


}