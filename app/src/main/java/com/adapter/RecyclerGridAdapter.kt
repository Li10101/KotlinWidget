package com.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.data.RecycleInfo
import com.kotlinptoject.R

class RecyclerGridAdapter(context :Context,private val infos:MutableList<RecycleInfo>) :RecycleBaseAdapter<RecyclerView.ViewHolder>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var inflate = inflater.inflate(R.layout.item_recycler_linear, parent, false)
        return GridViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var gridViewHolder = holder as GridViewHolder
        gridViewHolder.tv_title.text = infos[position].title
        gridViewHolder.ll_item.setOnClickListener(){v->
           itemClickListener!!.onItemClick(v,position)

        }
    }

    override fun getItemCount(): Int =infos.size

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ll_item = itemView.findViewById<LinearLayout>(R.id.ll_item)
        var tv_title = itemView.findViewById<TextView>(R.id.tv_title)
    }
}