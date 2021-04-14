package com.phonedev.openstore.ui.home

import android.content.Intent
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.phonedev.openstore.R
import com.phonedev.openstore.core.Resource
import com.phonedev.openstore.data.remote.AccScreenDataSource
import com.phonedev.openstore.databinding.FragmentAccListBinding
import com.phonedev.openstore.domain.AccScreenRepoImpl
import com.phonedev.openstore.presentation.AccScreenViewHolder
import com.phonedev.openstore.presentation.AccScreenViewModelFactory
import com.phonedev.openstore.ui.home.adapter.AccScreenAdapter


class fragment_acc_list : Fragment(R.layout.fragment_acc_list), AccScreenAdapter.accOnClickListener {

    private lateinit var binding: FragmentAccListBinding
    private val viewModel by viewModels<AccScreenViewHolder> {
        AccScreenViewModelFactory(AccScreenRepoImpl(
                AccScreenDataSource()
        ))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAccListBinding.bind(view)

        viewModel.fetchAllAcc().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rvAcc.adapter = AccScreenAdapter(result.data)
                }

                is Resource.Failure<*> -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Error: ${result.exception}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun onCellClickListener(data: Any) {
        findNavController().navigate(R.id.action_fragment_acc_list_to_fragment_item_detail)

    }
}