package com.natiqhaciyef.worldart.ui.fragment.details.architecture

import android.content.Context
import android.os.Handler
import android.view.View
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.natiqhaciyef.worldart.R
import com.natiqhaciyef.worldart.common.objects.ErrorMessages
import com.natiqhaciyef.worldart.data.model.AdsModel
import com.natiqhaciyef.worldart.data.model.ArchitectureModel
import com.natiqhaciyef.worldart.databinding.EpoxyArchitectureBodyViewBinding
import com.natiqhaciyef.worldart.databinding.EpoxyArchitectureHeaderViewBinding
import com.natiqhaciyef.worldart.databinding.EpoxyContainerTextViewBinding
import com.natiqhaciyef.worldart.databinding.EpoxyLoadingViewBinding
import com.natiqhaciyef.worldart.domain.model.UIResult
import com.natiqhaciyef.worldart.ui.adapter.AdsViewPagerAdapter
import com.natiqhaciyef.worldart.ui.adapter.ArchAdapter
import com.natiqhaciyef.worldart.ui.base.BaseEventController
import com.natiqhaciyef.worldart.ui.base.ViewBindingKotlinModel
import com.natiqhaciyef.worldart.ui.fragment.home.HomeEpoxyController

class ArchitectureEpoxyController(
    context: Context,
    viewModel: ArchitectureViewModel,
) : BaseEventController<ArchitectureViewModel>(context, viewModel) {

    var isLoading: Boolean = true
        set(value) {
            field = value
            if (field) {
                requestModelBuild()
            }
        }

    var model: ArchitectureEpoxyModel? = null
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
            LoadingEpoxyModel().id("arch_loading").addTo(this)
            return
        }

        if (model == null) {
            // if null state
            ArchMessageContainerEpoxyModel().id("arch_error_message").addTo(this)
            return
        }

        ArchitectureEpoxyHeaderModel(
            context = context,
            list = model!!.ads
        ).id("arch_header").addTo(this)


        ArchitectureEpoxyBodyModel(
            context = context,
            categories = model!!.categories,
            list = model!!.archs
        ).id("arch_body").addTo(this)
    }

    data class ArchitectureEpoxyHeaderModel(
        val context: Context,
        val list: List<UIResult<AdsModel>>,
    ) : ViewBindingKotlinModel<EpoxyArchitectureHeaderViewBinding>(R.layout.epoxy_architecture_header_view) {
        override fun EpoxyArchitectureHeaderViewBinding.bind() {
            val adapter = AdsViewPagerAdapter(context, list)

            adsViewPager.adapter = adapter
            val handler = Handler()
            val runnable = Runnable {
                adsViewPager.currentItem = (adsViewPager.currentItem + 1) % list.size
            }
            val delay = 4500L
            handler.postDelayed(runnable, delay)
        }
    }

    data class ArchitectureEpoxyBodyModel(
        val context: Context,
        val categories: List<String>,
        val list: List<UIResult<ArchitectureModel>>,
    ) : ViewBindingKotlinModel<EpoxyArchitectureBodyViewBinding>(R.layout.epoxy_architecture_body_view) {
        override fun EpoxyArchitectureBodyViewBinding.bind() {
            val archAdapter = ArchAdapter(context, list)
            archPostsRecyclerView.adapter = archAdapter
            archPostsRecyclerView.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

            archAdapter.onClickAction(archPostClickEvent)
        }
    }

    class LoadingEpoxyModel :
        ViewBindingKotlinModel<EpoxyLoadingViewBinding>(R.layout.epoxy_loading_view) {
        override fun EpoxyLoadingViewBinding.bind() {

        }
    }

    data class ArchMessageContainerEpoxyModel(
        val text: String = ErrorMessages.DATA_NOT_FOUND,
    ) : ViewBindingKotlinModel<EpoxyContainerTextViewBinding>(R.layout.epoxy_container_text_view) {
        override fun EpoxyContainerTextViewBinding.bind() {
            containerTitle.visibility = View.GONE
            messageContainerText.text = text
        }
    }

    companion object {
        var archPostClickEvent: (UIResult<ArchitectureModel>) -> Unit = {}
    }
}