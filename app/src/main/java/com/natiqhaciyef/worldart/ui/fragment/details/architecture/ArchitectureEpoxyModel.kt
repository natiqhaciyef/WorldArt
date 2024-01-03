package com.natiqhaciyef.worldart.ui.fragment.details.architecture

import com.natiqhaciyef.worldart.data.model.AdsModel
import com.natiqhaciyef.worldart.data.model.ArchitectureModel
import com.natiqhaciyef.worldart.domain.model.UIResult

data class ArchitectureEpoxyModel(
    val categories: List<String>,
    val ads: List<UIResult<AdsModel>>,
    val archs: List<UIResult<ArchitectureModel>>,
)
