package com.natiqhaciyef.worldart.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.natiqhaciyef.worldart.data.model.HistoryModel
import com.natiqhaciyef.worldart.databinding.RecyclerHistoryItemViewBinding
import com.natiqhaciyef.worldart.domain.model.UIResult

class HistoryAdapter(
    private val context: Context,
    private val list: List<UIResult<HistoryModel>>
) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    private var onClickAction: (UIResult<HistoryModel>) -> Unit = {}

    inner class HistoryViewHolder(val binding: RecyclerHistoryItemViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding =
            RecyclerHistoryItemViewBinding.inflate(LayoutInflater.from(context), parent, false)
        return HistoryViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val view = holder.binding
        val historyModel = list[position]

        if (position % 2 == 1) {
            view.historyImageLeft.visibility = View.GONE
            view.historyImageRight.visibility = View.VISIBLE
            Glide.with(context).load(historyModel.data.image).into(view.historyImageRight)
        } else {
            view.historyImageLeft.visibility = View.GONE
            view.historyImageRight.visibility = View.VISIBLE
            Glide.with(context).load(historyModel.data.image).into(view.historyImageLeft)
        }

        view.historyTitleText.text = historyModel.data.title
        holder.itemView.setOnClickListener { onClickAction.invoke(historyModel) }
    }

    fun onClick(action: (UIResult<HistoryModel>) -> Unit) {
        onClickAction = action
    }
}