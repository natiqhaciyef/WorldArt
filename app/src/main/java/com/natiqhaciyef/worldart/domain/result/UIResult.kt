package com.natiqhaciyef.worldart.domain.result

import com.natiqhaciyef.worldart.data.model.ScienceModel

data class UIResult<T>(
    var id: Int,
    var data: T,
    var publishDate: String
)
