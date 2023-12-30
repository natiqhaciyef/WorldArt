package com.natiqhaciyef.worldart.ui.fragment.home

import android.os.Build
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.natiqhaciyef.worldart.R
import com.natiqhaciyef.worldart.databinding.FragmentHomeBinding
import com.natiqhaciyef.worldart.ui.adapter.ArtAdapter
import com.natiqhaciyef.worldart.ui.adapter.PostAdapter
import com.natiqhaciyef.worldart.ui.model.ArtFieldModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var artFieldAdapter: ArtAdapter
    private lateinit var postAdapter: PostAdapter
    private val homeViewModel: HomeViewModel by viewModels()
    private var homeEventController: HomeEventController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()

        artFieldAdapter = ArtAdapter(requireContext(), artFieldsList)
        binding.recyclerArtFields.adapter = artFieldAdapter
        binding.recyclerArtFields.layoutManager =
            GridLayoutManager(requireContext(), 3, GridLayoutManager.VERTICAL, false)
        if (homeEventController != null) {
            artFieldAdapter.onClickAction(homeEventController!!.artFieldOnClickEvent)
        }

        homeViewModel.postState.observe(viewLifecycleOwner) {
            postAdapter = PostAdapter(requireContext(), it.dataSet)
            binding.recyclerPostsView.adapter = postAdapter
            binding.recyclerPostsView.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            if (homeEventController != null) {
                postAdapter.likeClickAction(homeEventController!!.likeIconClickEvent)
                postAdapter.shareClickAction(homeEventController!!.shareIconClickEvent)
                postAdapter.saveClickAction(homeEventController!!.saveIconClickEvent)
                postAdapter.settingClickAction(homeEventController!!.settingIconClickEvent)
            }
        }
    }

    private fun setup() {
        homeEventController = HomeEventController(homeViewModel)

        homeViewModel.userState.observe(viewLifecycleOwner) {
            val title = if (it.isSuccess) it.data?.name else "Friend"
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                binding.greetingTitle.text =
                    Html.fromHtml(
                        getString(R.string.hello_user, title),
                        Html.FROM_HTML_MODE_COMPACT
                    )
            } else {
                binding.greetingTitle.text = Html.fromHtml(getString(R.string.hello_user, title))
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