package com.geektech.lovecalculator44.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalculator44.App
import com.geektech.lovecalculator44.Model.LoveViewModel
import com.geektech.lovecalculator44.Prefs
import com.geektech.lovecalculator44.R
import com.geektech.lovecalculator44.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: LoveViewModel by viewModels()

    @Inject
    lateinit var prefs: Prefs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
        onBoard()
    }

    private fun onBoard() {
        if (!prefs.isShown(requireContext())) {
            findNavController().navigate(R.id.boardFragment)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnCalculate.setOnClickListener {
                val firstName = etBoy.text.toString()
                val secondName = etGirl.text.toString()
                viewModel.getLiveLoveModel(firstName,secondName).observe(viewLifecycleOwner
                ) { loveModel ->
                    Log.e("ololo", "initClickers: $loveModel")
                    App.db.historyDao().insert(loveModel)
                    val bundle = Bundle()
                    bundle.putSerializable("love", loveModel)
                    findNavController().navigate(R.id.resultFragment, bundle)
                    etBoy.text.clear()
                    etGirl.text.clear()
                }
            }
            btnHistory.setOnClickListener {
                findNavController().navigate(R.id.historyFragment)
            }
        }
    }

}
