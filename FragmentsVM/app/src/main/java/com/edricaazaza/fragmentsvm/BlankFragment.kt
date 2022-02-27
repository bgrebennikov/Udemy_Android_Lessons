package com.edricaazaza.fragmentsvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.edricaazaza.fragmentsvm.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {

    private var _binding : FragmentBlankBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<FragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.timerText.observe(viewLifecycleOwner){
            binding.timerText.text = it
        }

        binding.resetTimer.setOnClickListener { viewModel.resetTimer() }

    }

}