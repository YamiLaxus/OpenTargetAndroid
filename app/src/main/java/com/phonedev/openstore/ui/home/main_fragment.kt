package com.phonedev.openstore.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.phonedev.openstore.R

class main_fragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn = view.findViewById<ImageButton>(R.id.btnPhone)
        val btnT = view.findViewById<ImageButton>(R.id.btnTablet)
        val btnA = view.findViewById<ImageButton>(R.id.btnAcc)
        val btnC = view.findViewById<ImageButton>(R.id.btnTazas)

        btn.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_main_to_fragment_phone_list)
        }

        btnT.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_main_to_fragment_talbet_list)
        }

        btnA.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_main_to_fragment_acc_list)
        }

        btnC.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_main_to_fragment_cup_list)
        }
    }
}