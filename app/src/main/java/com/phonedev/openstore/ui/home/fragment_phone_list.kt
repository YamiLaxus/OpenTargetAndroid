package com.phonedev.openstore.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.phonedev.openstore.R
import com.phonedev.openstore.core.Resource
import com.phonedev.openstore.data.model.PhoneModel
import com.phonedev.openstore.data.remote.PhoneScreenDataSource
import com.phonedev.openstore.databinding.FragmentPhoneListBinding
import com.phonedev.openstore.databinding.PhoneItemViewBinding
import com.phonedev.openstore.domain.PhoneScreenRepoImpl
import com.phonedev.openstore.presentation.PhoneScreeViewModelFactory
import com.phonedev.openstore.presentation.PhoneScreenViewModel
import com.phonedev.openstore.ui.home.adapter.PhoneScreenAdapter

class fragment_phone_list : Fragment(R.layout.fragment_phone_list) {

    private lateinit var binding: FragmentPhoneListBinding
    private val viewModel by viewModels<PhoneScreenViewModel> {
        PhoneScreeViewModelFactory(PhoneScreenRepoImpl(
                PhoneScreenDataSource()
        ))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPhoneListBinding.bind(view)

        viewModel.fetchAllPhones().observe(viewLifecycleOwner, Observer { result ->

            when (result) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rvPhone.adapter = PhoneScreenAdapter(result.data)
                }

                is Resource.Failure<*> -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Error: ${result.exception}", Toast.LENGTH_SHORT).show()
                }
            }

        })
    }
}