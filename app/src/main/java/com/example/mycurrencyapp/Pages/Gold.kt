package com.example.mycurrencyapp.Pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycurrencyapp.Adapters.CurrencyAdapter
import com.example.mycurrencyapp.Adapters.GoldAdapter
import com.example.mycurrencyapp.Model.Api
import com.example.mycurrencyapp.Model.CurrencyViewModel
import com.example.mycurrencyapp.databinding.FragmentGoldBinding
import com.example.mycurrencyapp.databinding.FragmentListBinding


class Gold : Fragment() {

    private lateinit var viewModel: CurrencyViewModel
    private lateinit var binding: FragmentGoldBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentGoldBinding.inflate(inflater, container, false)
        binding.kurlar.layoutManager = LinearLayoutManager(context)
        viewModel = ViewModelProvider(this).get(CurrencyViewModel::class.java)
        viewModel.apiResponse.observe(
            viewLifecycleOwner,
        ) { apiResponse ->
            apiResponse?.let {
                binding.kurlar.adapter = GoldAdapter(it)
            }
        }
        return binding.root
    }

}