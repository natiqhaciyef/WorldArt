package com.natiqhaciyef.worldart.ui.fragment.details.architecture

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.natiqhaciyef.worldart.R
import com.natiqhaciyef.worldart.databinding.FragmentArchitectureMainBinding
import com.natiqhaciyef.worldart.ui.base.BaseFragment
import com.natiqhaciyef.worldart.ui.fragment.home.HomeEpoxyModel
import com.natiqhaciyef.worldart.ui.fragment.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ArchitectureMainFragment : BaseFragment() {
    private lateinit var binding: FragmentArchitectureMainBinding
    private val architectureViewModel: ArchitectureViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentArchitectureMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val archEventController = ArchitectureEpoxyController(requireContext(), architectureViewModel)

        architectureViewModel.adsState.observe(viewLifecycleOwner) { adList ->
            architectureViewModel.archState.observe(viewLifecycleOwner) { archList ->
                archEventController.model = ArchitectureEpoxyModel(
                    categories = listOf(),
                    ads = adList.dataSet ?: listOf(),
                    archs = archList.dataSet ?: listOf()
//                    archs = listOf()
                )

                binding.epoxyArchitectureView.setControllerAndBuildModels(archEventController)
            }
        }
    }
}