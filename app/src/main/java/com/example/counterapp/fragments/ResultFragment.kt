package com.example.counterapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.counterapp.R
import com.example.counterapp.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private  val resultFragmentArgs: ResultFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            txtResult.txtResult.text = resultFragmentArgs.numbers.number.toString()
            txtResult.circularProgressBar.progress=resultFragmentArgs.numbers.number
            root.setBackgroundResource(R.drawable.background_color)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}