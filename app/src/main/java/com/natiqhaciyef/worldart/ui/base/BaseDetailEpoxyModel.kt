package com.natiqhaciyef.worldart.ui.base

import com.natiqhaciyef.worldart.data.model.AdsModel
import com.natiqhaciyef.worldart.domain.model.UIResult

open class BaseDetailEpoxyModel<T>(
    val data: List<UIResult<T>>,
    val categories: List<String>,
    val ads: List<UIResult<AdsModel>>
)
