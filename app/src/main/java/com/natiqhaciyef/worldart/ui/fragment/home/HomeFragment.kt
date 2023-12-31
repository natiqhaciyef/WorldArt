package com.natiqhaciyef.worldart.ui.fragment.home

import android.os.Build
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.viewModels
import androidx.navigation.NavDeepLinkBuilder
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.EpoxyRecyclerView
import com.natiqhaciyef.worldart.R
import com.natiqhaciyef.worldart.common.helpers.getNow
import com.natiqhaciyef.worldart.common.helpers.toSQLiteString
import com.natiqhaciyef.worldart.data.model.AdsModel
import com.natiqhaciyef.worldart.data.model.ArchitectureModel
import com.natiqhaciyef.worldart.data.model.ArtistModel
import com.natiqhaciyef.worldart.data.model.PlaceModel
import com.natiqhaciyef.worldart.data.model.enums.AdCategories
import com.natiqhaciyef.worldart.data.model.enums.ArtField
import com.natiqhaciyef.worldart.databinding.FragmentHomeBinding
import com.natiqhaciyef.worldart.ui.adapter.ArtAdapter
import com.natiqhaciyef.worldart.ui.adapter.PostAdapter
import com.natiqhaciyef.worldart.ui.base.BaseFragment
import com.natiqhaciyef.worldart.ui.base.BaseNavigationDeepLink
import com.natiqhaciyef.worldart.ui.fragment.admin.AdminViewModel
import com.natiqhaciyef.worldart.ui.fragment.details.architecture.ArchitectureMainFragment
import com.natiqhaciyef.worldart.ui.model.ArtFieldModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {
    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()
    private var homeEpoxyModel: HomeEpoxyModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {
        val homeEventController = HomeEpoxyController(requireContext(), homeViewModel)
        homeEpoxyModel = HomeEpoxyModel()

        homeViewModel.postState.observe(viewLifecycleOwner) { post ->
            homeViewModel.userState.observe(viewLifecycleOwner) { user ->
                val title = if (user.isSuccess) user.data?.name else "Friend"

                homeEventController.model = HomeEpoxyModel(
                    username = title,
                    artList = artFieldsList,
                    postList = post.dataSet ?: listOf()
                )

                HomeEpoxyController.artFieldOnClickEvent = { art, navLink ->
                    handleDeepLink(navLink)
                }

                binding.epoxyHomeView.setControllerAndBuildModels(homeEventController)
            }
        }
    }

    companion object {
        val artFieldsList = listOf(
            ArtFieldModel(title = "Architecture", image = "architecture_icon"),
            ArtFieldModel(title = "History", image = "history_icon"),
            ArtFieldModel(title = "Painting", image = "painting_icon"),
            ArtFieldModel(title = "Science", image = "science_icon"),
            ArtFieldModel(title = "Travel", image = "travel_icon"),
            ArtFieldModel(title = "Technology", image = "technology_icon"),
        )
    }
}