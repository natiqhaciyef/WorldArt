package com.natiqhaciyef.worldart.ui.fragment.details.architecture

import android.content.Context
import android.os.Handler
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.natiqhaciyef.worldart.R
import com.natiqhaciyef.worldart.common.objects.ErrorMessages
import com.natiqhaciyef.worldart.data.model.AdsModel
import com.natiqhaciyef.worldart.data.model.ArchitectureModel
import com.natiqhaciyef.worldart.databinding.EpoxyContainerTextViewBinding
import com.natiqhaciyef.worldart.databinding.EpoxyDetailsBodyViewBinding
import com.natiqhaciyef.worldart.databinding.EpoxyDetailsHeaderViewBinding
import com.natiqhaciyef.worldart.databinding.EpoxyLoadingViewBinding
import com.natiqhaciyef.worldart.domain.model.UIResult
import com.natiqhaciyef.worldart.ui.adapter.AdsViewPagerAdapter
import com.natiqhaciyef.worldart.ui.adapter.ArchAdapter
import com.natiqhaciyef.worldart.ui.adapter.CategoryAdapter
import com.natiqhaciyef.worldart.ui.base.BaseDetailEpoxyModel
import com.natiqhaciyef.worldart.ui.base.BaseEventController
import com.natiqhaciyef.worldart.ui.base.ViewBindingKotlinModel

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

    var model: BaseDetailEpoxyModel<ArchitectureModel>? = null
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

        if (model == null || model?.data.isNullOrEmpty() || model?.ads.isNullOrEmpty()) {
            // if null state
            println("alma")
            ArchMessageContainerEpoxyModel().id("arch_error_message").addTo(this)
            return
        }

        ArchitectureEpoxyHeaderModel(
            context = context, list = model!!.ads
        ).id("arch_header").addTo(this)

        ArchitectureEpoxyBodyModel(
            context = context, categories = model!!.categories, list = model!!.data
        ).id("arch_body").addTo(this)
    }

    data class ArchitectureEpoxyHeaderModel(
        val context: Context,
        val list: List<UIResult<AdsModel>>,
    ) : ViewBindingKotlinModel<EpoxyDetailsHeaderViewBinding>(R.layout.epoxy_details_header_view) {
        override fun EpoxyDetailsHeaderViewBinding.bind() {
            val handler = Handler()
            val adapter = AdsViewPagerAdapter(context, list)
            adsViewPager.adapter = adapter
            detailsTitle.text = generateTitle("architecture")

            if (list.isNotEmpty()) {
                val runnable = Runnable {
                    adsViewPager.currentItem = (adsViewPager.currentItem + 1) % list.size
                }
                val delay = 4500L
                handler.postDelayed(runnable, delay)
            }
        }
    }

    data class ArchitectureEpoxyBodyModel(
        val context: Context,
        val categories: List<String>,
        val list: List<UIResult<ArchitectureModel>>,
    ) : ViewBindingKotlinModel<EpoxyDetailsBodyViewBinding>(R.layout.epoxy_details_body_view) {
        override fun EpoxyDetailsBodyViewBinding.bind() {
            val archAdapter = ArchAdapter(context, list)
            detailsPostsRecyclerView.adapter = archAdapter
            detailsPostsRecyclerView.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

            archAdapter.onClickAction(eventClickActionWithData {

            })


            if (categories.isNotEmpty()) {
                val categoryAdapter = CategoryAdapter(categories)
                categoriesRecyclerView.adapter = categoryAdapter
                categoriesRecyclerView.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            }
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
            containerTitle.visibility = View.INVISIBLE
            messageContainerText.text = text
        }
    }

}