package com.baharudin.wallpaperapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.baharudin.wallpaperapp.R
import com.baharudin.wallpaperapp.databinding.FragmentGeleryBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GaleryFragment : Fragment(R.layout.fragment_gelery) {

    private val viewModel by viewModels<GaleryViewModel>()
    private var _binding : FragmentGeleryBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentGeleryBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        viewModel.photo.observe(viewLifecycleOwner,  {

        })
    }
}