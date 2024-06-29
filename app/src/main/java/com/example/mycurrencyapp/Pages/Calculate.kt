package com.example.mycurrencyapp.Pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycurrencyapp.Adapters.CurrencyAdapter
import com.example.mycurrencyapp.Adapters.ListAdapter
import com.example.mycurrencyapp.Model.Api
import com.example.mycurrencyapp.Model.CurrencyViewModel
import com.example.mycurrencyapp.R
import com.example.mycurrencyapp.databinding.FragmentCalculateBinding
import com.example.mycurrencyapp.databinding.FragmentListBinding


class Calculate : Fragment() {
    private lateinit var viewModel: CurrencyViewModel
    private lateinit var binding: FragmentCalculateBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCalculateBinding.inflate(inflater, container, false)
        binding.kurlar.layoutManager = LinearLayoutManager(context)
        viewModel = ViewModelProvider(this).get(CurrencyViewModel::class.java)
        viewModel.apiResponse.observe(
            viewLifecycleOwner,
        ) { apiResponse ->
            apiResponse?.let {
                binding.kurlar.adapter = CurrencyAdapter(it, this)
            }
        }
        return binding.root
    }
}