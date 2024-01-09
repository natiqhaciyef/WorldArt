package com.natiqhaciyef.worldart.ui.fragment.details.history

import android.content.Context
import android.os.Handler
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.natiqhaciyef.worldart.R
import com.natiqhaciyef.worldart.common.objects.ErrorMessages
import com.natiqhaciyef.worldart.data.model.AdsModel
import com.natiqhaciyef.worldart.data.model.ArchitectureModel
import com.natiqhaciyef.worldart.data.model.HistoryModel
import com.natiqhaciyef.worldart.databinding.EpoxyContainerTextViewBinding
import com.natiqhaciyef.worldart.databinding.EpoxyDetailsBodyViewBinding
import com.natiqhaciyef.worldart.databinding.EpoxyDetailsHeaderViewBinding
import com.natiqhaciyef.worldart.databinding.EpoxyLoadingViewBinding
import com.natiqhaciyef.worldart.domain.model.UIResult
import com.natiqhaciyef.worldart.ui.adapter.AdsViewPagerAdapter
import com.natiqhaciyef.worldart.ui.adapter.CategoryAdapter
import com.natiqhaciyef.worldart.ui.adapter.HistoryAdapter
import com.natiqhaciyef.worldart.ui.base.BaseDetailEpoxyModel
import com.natiqhaciyef.worldart.ui.base.BaseEventController
import com.natiqhaciyef.worldart.ui.base.ViewBindingKotlinModel
import com.natiqhaciyef.worldart.ui.fragment.details.architecture.ArchitectureEpoxyController

class HistoryEpoxyController(
    context: Context,
    viewModel: HistoryViewModel,
) : BaseEventController<HistoryViewModel>(context, viewModel) {

    var isLoading: Boolean = true
        set(value) {
            field = value
            if (field) {
                requestModelBuild()
            }
        }

    var model: BaseDetailEpoxyModel<HistoryModel>? = null
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
            LoadingEpoxyModel().id("history_loading").addTo(this)
            return
        }

        if (model == null || model?.data.isNullOrEmpty() || model?.ads.isNullOrEmpty()) {
            // if null state
            println("alma")
            HistoryMessageContainerEpoxyModel().id("history_error_message").addTo(this)
            return
        }

        HistoryEpoxyHeaderModel(
            context = context, list = model!!.ads
        ).id("history_header").addTo(this)

        HistoryEpoxyBodyModel(
            context = context, categories = model!!.categories, list = model!!.data
        ).id("history_body").addTo(this)
    }

    data class HistoryEpoxyHeaderModel(
        val context: Context,
        val list: List<UIResult<AdsModel>>,
    ) : ViewBindingKotlinModel<EpoxyDetailsHeaderViewBinding>(R.layout.epoxy_details_header_view) {
        override fun EpoxyDetailsHeaderViewBinding.bind() {
            val handler = Handler()
            val adapter = AdsViewPagerAdapter(context, list)
            detailsTitle.text = generateTitle("history")
            adsViewPager.adapter = adapter

            if (list.isNotEmpty()) {
                val runnable = Runnable {
                    adsViewPager.currentItem = (adsViewPager.currentItem + 1) % list.size
                }
                val delay = 4500L
                handler.postDelayed(runnable, delay)
            }
        }
    }

    data class HistoryEpoxyBodyModel(
        val context: Context,
        val list: List<UIResult<HistoryModel>>,
        val categories: List<String>
    ) : ViewBindingKotlinModel<EpoxyDetailsBodyViewBinding>(R.layout.epoxy_details_body_view) {
        override fun EpoxyDetailsBodyViewBinding.bind() {
            val adapter = HistoryAdapter(context, list)
            detailsPostsRecyclerView.adapter = adapter
            detailsPostsRecyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)

            if (categories.isNotEmpty()) {
                val categoryAdapter = CategoryAdapter(categories)
                categoriesRecyclerView.adapter = categoryAdapter
                categoriesRecyclerView.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            }
        }
    }

    class LoadingEpoxyModel : ViewBindingKotlinModel<EpoxyLoadingViewBinding>(R.layout.epoxy_loading_view) {
        override fun EpoxyLoadingViewBinding.bind() {

        }
    }

    data class HistoryMessageContainerEpoxyModel(
        val text: String = ErrorMessages.DATA_NOT_FOUND,
    ) : ViewBindingKotlinModel<EpoxyContainerTextViewBinding>(R.layout.epoxy_container_text_view) {
        override fun EpoxyContainerTextViewBinding.bind() {
            containerTitle.visibility = View.INVISIBLE
            messageContainerText.text = text
        }
    }

}