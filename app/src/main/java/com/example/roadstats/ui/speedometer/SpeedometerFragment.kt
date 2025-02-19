package com.example.roadstats.ui.speedometer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.roadstats.databinding.FragmentSpeedometerBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpeedometerFragment : Fragment() {
    private val speedometerViewModel: SpeedometerViewModel by viewModel()
    private var _binding: FragmentSpeedometerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpeedometerBinding.inflate(inflater, container, false)

        speedometerViewModel.speed.observe(viewLifecycleOwner, Observer { speed ->
            binding.speedometer.text = "$speed"
        })
        speedometerViewModel.mileage.observe(viewLifecycleOwner, Observer { mileage ->
            binding.mileage.text = "$mileage"
        })
        startTracking()
        return binding.root
    }

    private fun startTracking() {
        speedometerViewModel.startSpeedTracking()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}