package com.natiqhaciyef.worldart.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.natiqhaciyef.worldart.databinding.RecyclerHomeCardItemBinding
import com.natiqhaciyef.worldart.ui.model.ArtFieldModel

class ArtAdapter(
    private val context: Context,
    private val list: List<ArtFieldModel>
) : RecyclerView.Adapter<ArtAdapter.ArtViewHolder>() {

    inner class ArtViewHolder(val binding: RecyclerHomeCardItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtViewHolder {
        val binding =
            RecyclerHomeCardItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ArtViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ArtViewHolder, position: Int) {
        val view = holder.binding
        val art = list[position]

        view.artIcon
            .setImageResource(context.resources.getIdentifier(art.image, "drawable", context.packageName))
        view.artTitle.text = art.title
    }
}