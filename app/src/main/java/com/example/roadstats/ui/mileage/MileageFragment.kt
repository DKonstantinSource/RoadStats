package com.example.roadstats.ui.mileage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roadstats.databinding.FragmentMileageBinding
import com.example.roadstats.ui.mileage.adapter.MileageAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MileageFragment : Fragment() {

    private var _binding: FragmentMileageBinding? = null
    private val binding get() = _binding!!

    private val mileageViewModel: MileageViewModel by viewModel()
    private lateinit var mileageAdapter: MileageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMileageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mileageAdapter = MileageAdapter(emptyList())
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mileageAdapter
        }

        mileageViewModel.allMileage.observe(viewLifecycleOwner) { mileageList ->
            mileageAdapter.updateList(mileageList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
