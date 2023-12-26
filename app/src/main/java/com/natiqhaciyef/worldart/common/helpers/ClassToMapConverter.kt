package com.natiqhaciyef.hiproid.common.util.helpers

import com.google.firebase.firestore.DocumentSnapshot
import com.natiqhaciyef.hiproid.data.models.ChatModel
import com.natiqhaciyef.hiproid.data.models.StoryModel


fun ChatModel.toMutableMap(): HashMap<String, Any>{
    val map = hashMapOf<String, Any>()
    map["id"] = this.id
    map["destination"] = this.destination
    map["messages"] = this.messages
    return map
}

fun StoryModel.toMutableMap(): HashMap<String, Any?>?{
    val map = hashMapOf<String, Any?>()
    return if ((this.image != null || this.color != null) && this.text != null) {
        map["id"] = this.id
        map["image"] = this.image
        map["text"] = this.text
        map["color"] = this.color
        map["viewers"] = this.viewers
        map["publishDate"] = this.publishDate
        map
    }else{
        null
    }
}

fun DocumentSnapshot.toStoryModel(): StoryModel {
    return StoryModel(
        id = this["id"].toString().toInt(),
        image = this["image"].toString(),
        text = this["text"].toString(),
        color = this["color"].toString(),
        viewers = this["viewers"].toString(),
        publishDate = this["publishDate"].toString(),
        user = this["user"].toString()
    )
}


fun DocumentSnapshot.toChatModel(): ChatModel {
    return ChatModel(
        id = this["id"].toString().toInt(),
        destination = this["destination"].toString(),
        messages = this["messages"] as MutableList<String>
    )
}