package com.natiqhaciyef.worldart.ui.fragment.home

import com.natiqhaciyef.worldart.domain.model.MappedPostModel
import com.natiqhaciyef.worldart.domain.model.UIResult
import com.natiqhaciyef.worldart.ui.model.ArtFieldModel

data class HomeEpoxyModel(
    var username: String? = null,
    var artList: List<ArtFieldModel> = listOf(),
    var postList: List<UIResult<MappedPostModel>> = listOf()
)
