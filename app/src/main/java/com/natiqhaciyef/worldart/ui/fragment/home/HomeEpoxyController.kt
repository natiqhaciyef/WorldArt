package com.natiqhaciyef.worldart.ui.fragment.home

import android.content.Context
import android.os.Build
import android.text.Html
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.natiqhaciyef.worldart.R
import com.natiqhaciyef.worldart.databinding.EpoxyHomeBodyViewBinding
import com.natiqhaciyef.worldart.databinding.EpoxyHomeFooterViewBinding
import com.natiqhaciyef.worldart.databinding.EpoxyHomeHeaderViewBinding
import com.natiqhaciyef.worldart.databinding.EpoxyLoadingViewBinding
import com.natiqhaciyef.worldart.domain.model.MappedPostModel
import com.natiqhaciyef.worldart.domain.model.UIResult
import com.natiqhaciyef.worldart.ui.adapter.ArtAdapter
import com.natiqhaciyef.worldart.ui.adapter.PostAdapter
import com.natiqhaciyef.worldart.ui.base.BaseEventController
import com.natiqhaciyef.worldart.ui.base.ViewBindingKotlinModel
import com.natiqhaciyef.worldart.ui.model.ArtFieldModel

class HomeEpoxyController(
    context: Context,
    homeViewModel: HomeViewModel?
) : BaseEventController<HomeViewModel>(context, homeViewModel) {

    companion object {
        var artFieldOnClickEvent: (ArtFieldModel, String) -> Unit = { art, navLink -> }
        val likeIconClickEvent: (Boolean) -> Unit = {}
        val saveIconClickEvent: (Boolean) -> Unit = {}
        val settingIconClickEvent: () -> Unit = {}
        val shareIconClickEvent: (UIResult<MappedPostModel>) -> Unit = {}
    }

    var isLoading: Boolean = true
        set(value) {
            field = value
            if (field) {
                requestModelBuild()
            }
        }

    var model: HomeEpoxyModel? = null
        set(value) {
            field = value
            if (field != null) {
                isLoading = false
                requestModelBuild()
            }
        }

    override fun buildModels() {
        if (isLoading) {
            // shows loading state
            LoadingEpoxyModel().id("home_loading").addTo(this)
            return
        }

        if (model == null) {
            // if null state
            return
        }

        HomeHeaderEpoxyModel(
            context = context,
            username = model?.username ?: "Friend"
        ).id("home_header").addTo(this)

        HomeBodyEpoxyModel(
            context = context,
            list = model?.artList ?: listOf()
        ).id("home_body").addTo(this)

        HomeFooterEpoxyModel(
            context = context,
            list = model?.postList ?: listOf()
        ).id("home_footer").addTo(this)
    }


    data class HomeHeaderEpoxyModel(
        var context: Context,
        var username: String,
    ) : ViewBindingKotlinModel<EpoxyHomeHeaderViewBinding>(R.layout.epoxy_home_header_view) {
        override fun EpoxyHomeHeaderViewBinding.bind() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                greetingTitle.text =
                    Html.fromHtml(
                        context.getString(R.string.hello_user, username),
                        Html.FROM_HTML_MODE_COMPACT
                    )
            } else {
                greetingTitle.text = Html.fromHtml(context.getString(R.string.hello_user, username))
            }
        }
    }


    data class HomeBodyEpoxyModel(
        val context: Context,
        val list: List<ArtFieldModel>
    ) : ViewBindingKotlinModel<EpoxyHomeBodyViewBinding>(R.layout.epoxy_home_body_view) {
        override fun EpoxyHomeBodyViewBinding.bind() {
            val artFieldAdapter = ArtAdapter(context, list)
            recyclerArtFields.adapter = artFieldAdapter
            recyclerArtFields.layoutManager =
                GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
            artFieldAdapter.onClickAction(artFieldOnClickEvent)
        }
    }

    data class HomeFooterEpoxyModel(
        val context: Context,
        val list: List<UIResult<MappedPostModel>>
    ) : ViewBindingKotlinModel<EpoxyHomeFooterViewBinding>(R.layout.epoxy_home_footer_view) {
        override fun EpoxyHomeFooterViewBinding.bind() {
            val postAdapter = PostAdapter(context, list)
            recyclerPostsView.adapter = postAdapter
            recyclerPostsView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                postAdapter.likeClickAction(likeIconClickEvent)
                postAdapter.shareClickAction(shareIconClickEvent)
                postAdapter.saveClickAction(saveIconClickEvent)
                postAdapter.settingClickAction(settingIconClickEvent)
        }
    }

    class LoadingEpoxyModel :
        ViewBindingKotlinModel<EpoxyLoadingViewBinding>(R.layout.epoxy_loading_view) {
        override fun EpoxyLoadingViewBinding.bind() {

        }
    }
}