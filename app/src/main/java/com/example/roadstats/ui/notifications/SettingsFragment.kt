package com.example.roadstats.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import com.example.roadstats.databinding.FragmentSettingsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val settingsViewModel: SettingsViewModel by viewModel<SettingsViewModel>()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setupThemeSwitch()
        return root
    }

    private fun setupThemeSwitch() {
        val switchTheme: SwitchCompat = binding.themeSwitcher

        settingsViewModel.themePreference.observe(viewLifecycleOwner) { isChecked ->
            switchTheme.isChecked = isChecked
        }

        switchTheme.setOnCheckedChangeListener { _, isChecked ->
            settingsViewModel.setTheme(isChecked)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}