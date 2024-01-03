package com.natiqhaciyef.worldart.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.natiqhaciyef.worldart.data.model.AdsModel
import com.natiqhaciyef.worldart.databinding.PagerAdsItemBinding
import com.natiqhaciyef.worldart.domain.model.UIResult

class AdsViewPagerAdapter(
    private val context: Context,
    private val list: List<UIResult<AdsModel>>,
) : RecyclerView.Adapter<AdsViewPagerAdapter.AdsViewPagerViewHolder>(){

    inner class AdsViewPagerViewHolder(val binding: PagerAdsItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdsViewPagerViewHolder {
        val binding = PagerAdsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdsViewPagerViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AdsViewPagerViewHolder, position: Int) {
        val ad = list[position].data
        holder.binding.adTitle.text = ad.title
        Glide.with(context).load(ad.image).into(holder.binding.adImage)
    }

}