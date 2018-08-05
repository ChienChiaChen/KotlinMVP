package com.chiachen.kotlinmvp.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chiachen.kotlinmvp.R
import com.chiachen.kotlinmvp.data.api.model.SourceResponse
import kotlinx.android.synthetic.main.view_source_item.view.*

/**
 * Created by jianjiacheng on 2018/8/5.
 */
class SourceAdapter : RecyclerView.Adapter<SourceAdapter.SourceViewHolder>() {

    private var clickListener : ItemClickListener? = null
    private var items : List<SourceResponse.Sources>? = null

    fun setClickListener(clickListener: ItemClickListener) {
        this.clickListener = clickListener
    }

    fun getClickListener() : ItemClickListener? {
        return clickListener
    }

    fun setItems(items: List<SourceResponse.Sources>) {
        this.items = items
        notifyItemRangeInserted(0, items.size)
    }

    fun clearItems() {
        val count = itemCount
        this.items = null
        notifyItemRangeRemoved(0, count)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SourceViewHolder {
        return SourceViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.view_source_item, parent, false))
    }

    override fun onBindViewHolder(holder: SourceViewHolder, position: Int) {
        holder.bindView(items!![position])

        holder.itemView.setOnClickListener {
            if (getClickListener() != null) {
                getClickListener()!!.onItemClickListener(items!![position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    class SourceViewHolder internal constructor (itemView : View) : RecyclerView.ViewHolder(itemView) {

        var sourceItem: SourceResponse.Sources? = null

        fun bindView(sourceItem: SourceResponse.Sources) : Unit {
            this.sourceItem = sourceItem

            sourceItem.name?.let { itemView.title.text = sourceItem.name }
            sourceItem.category?.let { itemView.category.text = sourceItem.category }
            sourceItem.description?.let { itemView.description.text = sourceItem.description }
        }
    }

    interface ItemClickListener {
        fun onItemClickListener(item: SourceResponse.Sources)
    }
}