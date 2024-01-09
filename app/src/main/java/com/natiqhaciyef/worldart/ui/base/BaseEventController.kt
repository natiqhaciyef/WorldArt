package com.natiqhaciyef.worldart.ui.base

import android.content.Context
import com.airbnb.epoxy.EpoxyController
import com.natiqhaciyef.worldart.data.model.ArchitectureModel
import com.natiqhaciyef.worldart.domain.model.UIResult

abstract class BaseEventController<T : BaseViewModel>(
    var context: Context,
    var viewModel: T?
) : EpoxyController() {

    companion object {
        fun generateTitle(title: String) = "Art of $title"
        fun <K> eventClickActionWithData(action: (UIResult<K>) -> Unit): (UIResult<K>) -> Unit {
            return action
        }

    }
}