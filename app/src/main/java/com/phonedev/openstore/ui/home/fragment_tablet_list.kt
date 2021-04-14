package com.phonedev.openstore.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.phonedev.openstore.R
import com.phonedev.openstore.core.Resource
import com.phonedev.openstore.data.remote.TabletScreenDataSource
import com.phonedev.openstore.databinding.FragmentTalbetListBinding
import com.phonedev.openstore.domain.TabletScreenRepoImpl
import com.phonedev.openstore.presentation.TabletScreenVewModel
import com.phonedev.openstore.presentation.TabletScreenViewModelFactory
import com.phonedev.openstore.ui.home.adapter.TabletScreenAdapter


class fragment_tablet_list : Fragment(R.layout.fragment_talbet_list) {

    private lateinit var binding: FragmentTalbetListBinding
    private val viewModel by viewModels<TabletScreenVewModel> { TabletScreenViewModelFactory(TabletScreenRepoImpl(
        TabletScreenDataSource()
    ))}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTalbetListBinding.bind(view)

        viewModel.fetchAllTabs().observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Resource.Loading ->{
                    binding.progressBar.visibility = View.VISIBLE
                }

                is Resource.Success ->{
                    binding.progressBar.visibility = View.GONE
                    binding.rvTablet.adapter = TabletScreenAdapter(result.data)
                }

                is Resource.Failure<*> ->{
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Error: ${result.exception}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}