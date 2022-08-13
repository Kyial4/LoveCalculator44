package com.geektech.lovecalculator44.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geektech.lovecalculator44.App
import com.geektech.lovecalculator44.R
import com.geektech.lovecalculator44.ViewModel.HistoryAdapter
import com.geektech.lovecalculator44.databinding.FragmentHistoryBinding
import com.geektech.lovecalculator44.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    lateinit var adapter: HistoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeHistory()
    }

    private fun observeHistory() {
        App.db.historyDao().getAll().observe(viewLifecycleOwner) { data ->
            adapter = HistoryAdapter(data)
            binding.recyclerView.adapter = adapter
        }
    }



}