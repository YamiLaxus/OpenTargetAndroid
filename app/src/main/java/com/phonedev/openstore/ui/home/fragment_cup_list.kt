package com.phonedev.openstore.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.View.GONE
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.phonedev.openstore.R
import com.phonedev.openstore.core.Resource
import com.phonedev.openstore.data.remote.CupScreenDataSource
import com.phonedev.openstore.databinding.FragmentCupListBinding
import com.phonedev.openstore.domain.CupScreenRepoImpl
import com.phonedev.openstore.presentation.CupScreenViewModel
import com.phonedev.openstore.presentation.CupScreenViewModelFactory
import com.phonedev.openstore.ui.home.adapter.CupScreenAdapter

class fragment_cup_list : Fragment(R.layout.fragment_cup_list) {

    private lateinit var binding: FragmentCupListBinding
    private val viewModel by viewModels<CupScreenViewModel> { CupScreenViewModelFactory(CupScreenRepoImpl(CupScreenDataSource())) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCupListBinding.bind(view)

        viewModel.fetchAllCup().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is Resource.Success -> {
                    binding.progressBar.visibility = GONE
                    binding.rvCup.adapter = CupScreenAdapter(result.data)
                }

                is Resource.Failure<*> -> {
                    binding.progressBar.visibility = GONE
                    Toast.makeText(requireContext(), "Error: ${result.exception}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}