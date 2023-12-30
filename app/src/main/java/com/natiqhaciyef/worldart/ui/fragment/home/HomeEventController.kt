package com.natiqhaciyef.worldart.ui.fragment.home

import com.natiqhaciyef.worldart.domain.model.MappedPostModel
import com.natiqhaciyef.worldart.domain.model.UIResult
import com.natiqhaciyef.worldart.ui.base.BaseEventController
import com.natiqhaciyef.worldart.ui.model.ArtFieldModel

class HomeEventController(
    homeViewModel: HomeViewModel?
) : BaseEventController<HomeViewModel>(homeViewModel) {

    var artFieldOnClickEvent: (ArtFieldModel, String) -> Unit = { art, navLink -> }

    val likeIconClickEvent: (Boolean) -> Unit = {}
    val saveIconClickEvent: (Boolean) -> Unit = {}
    val settingIconClickEvent: () -> Unit = {}
    val shareIconClickEvent: (UIResult<MappedPostModel>) -> Unit = {}

}