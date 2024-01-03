package com.natiqhaciyef.worldart.domain.repository

import com.natiqhaciyef.worldart.domain.base.BaseRepository
import com.natiqhaciyef.worldart.domain.model.MappedPostModel
import com.natiqhaciyef.worldart.domain.model.UIResult

interface PostRepository: BaseRepository {
    suspend fun getAllPosts(): List<UIResult<MappedPostModel>>?
}