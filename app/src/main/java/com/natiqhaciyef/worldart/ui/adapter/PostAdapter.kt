package com.natiqhaciyef.worldart.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.natiqhaciyef.worldart.databinding.RecyclerPostItemBinding
import com.natiqhaciyef.worldart.domain.model.MappedPostModel
import com.natiqhaciyef.worldart.domain.model.UIResult

class PostAdapter(
    private val context: Context,
    private var list: List<UIResult<MappedPostModel>>
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    private var likeToggle = false
    private var saveToggle = false

    private var likeIconClick: (Boolean) -> Unit = {}
    private var saveIconClick: (Boolean) -> Unit = {}
    private var settingIconClick: () -> Unit = {}
    private var shareIconClick: (UIResult<MappedPostModel>) -> Unit = {}

    inner class PostViewHolder(val binding: RecyclerPostItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding =
            RecyclerPostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val view = holder.binding
        val uiResult = list[position]
        val post = uiResult.data

        view.postDescription.text = post.description
        view.postUsername.text = post.user.name

        Glide.with(context).load(post.image).into(view.postImage)

        view.postLikeIcon.setOnClickListener {
            likeToggle = !likeToggle
            likeIconClick.invoke(likeToggle)
        }

        view.postSaveIcon.setOnClickListener {
            saveToggle = !saveToggle
            saveIconClick.invoke(saveToggle)
        }

        view.postSettingsIcon.setOnClickListener {
            settingIconClick.invoke()
        }

        view.postShareIcon.setOnClickListener {
            shareIconClick.invoke(uiResult)
        }
    }


    fun likeClickAction(likeAct: (Boolean) -> Unit) {
        likeIconClick = likeAct
    }

    fun saveClickAction(saveAct: (Boolean) -> Unit) {
        saveIconClick = saveAct
    }

    fun settingClickAction(settingAct: () -> Unit) {
        settingIconClick = settingAct
    }

    fun shareClickAction(shareAct: (UIResult<MappedPostModel>) -> Unit) {
        shareIconClick = shareAct
    }
}