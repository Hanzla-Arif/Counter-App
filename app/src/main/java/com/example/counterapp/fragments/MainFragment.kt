package com.example.counterapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.counterapp.Events
import com.example.counterapp.R
import com.example.counterapp.databinding.FragmentMainBinding

import com.example.counterapp.viewmodel.MainViewModel
import kotlinx.coroutines.launch


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            add.setOnClickListener {
                viewModel.events(Events.Addition)
            }
            subtract.setOnClickListener {
                viewModel.events(Events.Subtraction)
            }
            reset.setOnClickListener {
                viewModel.events(Events.Reset)
            }

            lifecycleScope.launch {
                viewModel.currentValue.collect {
                    txtResult.text = it.number.toString()
                }
            }
            nextBtn.setOnClickListener {
                val currentModelValue = viewModel.currentValue.value
                val action = MainFragmentDirections.actionMainFragmentToResultFragment2(currentModelValue)
                findNavController().navigate(action)
            }
            root.setBackgroundResource(R.drawable.background_color)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}