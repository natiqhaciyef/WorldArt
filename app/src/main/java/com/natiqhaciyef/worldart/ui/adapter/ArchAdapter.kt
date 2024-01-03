package com.natiqhaciyef.worldart.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.natiqhaciyef.worldart.data.model.ArchitectureModel
import com.natiqhaciyef.worldart.databinding.RecyclerArchItemBinding
import com.natiqhaciyef.worldart.domain.model.UIResult
import com.natiqhaciyef.worldart.ui.fragment.details.architecture.ArchitectureViewModel

class ArchAdapter(
    private val context: Context,
    private val list: List<UIResult<ArchitectureModel>>,
) : RecyclerView.Adapter<ArchAdapter.ArchViewHolder>() {

    private var archPostClickAction: (UIResult<ArchitectureModel>) -> Unit = {}

    inner class ArchViewHolder(val binding: RecyclerArchItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArchViewHolder {
        val binding =
            RecyclerArchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArchViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ArchViewHolder, position: Int) {
        val view = holder.binding
        val archUIResult = list[position]
        val arch = archUIResult.data

        view.archTitle.text = arch.title
        Glide.with(context).load(arch.image).into(view.archImage)

        holder.itemView.setOnClickListener { archPostClickAction.invoke(archUIResult) }
    }

    fun onClickAction(archClick: (UIResult<ArchitectureModel>) -> Unit) {
        archPostClickAction = archClick
    }
}