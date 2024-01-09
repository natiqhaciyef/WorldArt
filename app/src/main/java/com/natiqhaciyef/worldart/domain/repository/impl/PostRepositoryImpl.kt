package com.natiqhaciyef.worldart.domain.repository.impl

import com.natiqhaciyef.worldart.data.source.PostSource
import com.natiqhaciyef.worldart.domain.mapper.toUIModel
import com.natiqhaciyef.worldart.domain.model.MappedPostModel
import com.natiqhaciyef.worldart.domain.model.UIResult
import com.natiqhaciyef.worldart.domain.repository.PostRepository

class PostRepositoryImpl(private val ds: PostSource) : PostRepository {
    override suspend fun getAllPosts(): List<UIResult<MappedPostModel>>? {
        return ds.getAllPostsRemote().postResult?.map { it.toUIModel() }
    }
}