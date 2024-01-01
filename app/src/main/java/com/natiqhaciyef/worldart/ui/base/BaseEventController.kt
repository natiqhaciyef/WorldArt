package com.natiqhaciyef.worldart.ui.base

import android.content.Context
import com.airbnb.epoxy.EpoxyController

abstract class BaseEventController<T: BaseViewModel>(
    var context: Context,
    var viewModel: T?
): EpoxyController()