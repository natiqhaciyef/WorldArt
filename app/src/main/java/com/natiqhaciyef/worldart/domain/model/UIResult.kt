package com.natiqhaciyef.worldart.domain.model

data class UIResult<T>(
    var id: Int,
    var data: T,
    var publishDate: String
)
