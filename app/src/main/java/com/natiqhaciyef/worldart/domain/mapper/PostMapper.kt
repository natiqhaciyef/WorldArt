package com.natiqhaciyef.worldart.domain.mapper

import com.google.gson.Gson
import com.natiqhaciyef.worldart.common.helpers.toSQLiteList
import com.natiqhaciyef.worldart.common.helpers.toSQLiteString
import com.natiqhaciyef.worldart.data.model.PaintingModel
import com.natiqhaciyef.worldart.data.model.PostModel
import com.natiqhaciyef.worldart.data.model.io.PaintingNetworkModel
import com.natiqhaciyef.worldart.data.model.io.PostNetworkModel
import com.natiqhaciyef.worldart.domain.model.MappedPostModel
import com.natiqhaciyef.worldart.domain.model.MappedUserWithoutPassword
import com.natiqhaciyef.worldart.domain.model.UIResult

fun UIResult<MappedPostModel>.toNetworkModel(): PostNetworkModel {
    val user = Gson().toJson(this.data.user)
    val likedUsers = this.data.likedUsers.map { Gson().toJson(it) }.toSQLiteString()
    val postModel = PostModel(user = user, description = this.data.description, likedUsers = likedUsers, image = this.data.image)

    val post = Gson().toJson(postModel)
    return PostNetworkModel(
        id = this.id,
        post = post,
        publishDate = this.publishDate
    )
}

fun PostNetworkModel.toUIModel(): UIResult<MappedPostModel> {
    val post = Gson().fromJson(this.post, PostModel::class.java)
    val user = Gson().fromJson(post.user, MappedUserWithoutPassword::class.java)
    val likedUsers = post.likedUsers.toSQLiteList()
        .map { Gson().fromJson(it, MappedUserWithoutPassword::class.java) }
    val mappedPostModel = MappedPostModel(
        user = user,
        description = post.description,
        likedUsers = likedUsers,
        image = post.image
    )

    return UIResult(
        id = this.id,
        data = mappedPostModel,
        publishDate = this.publishDate
    )
}