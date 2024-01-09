package com.natiqhaciyef.worldart.data.source

import com.natiqhaciyef.worldart.data.network.service.PostService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostSource(
    private val service: PostService
) {

    suspend fun getAllPostsRemote() = withContext(Dispatchers.IO) {
        service.getAllPosts()
    }

}