package com.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class RecycleBaseAdapter<VH :RecyclerView.ViewHolder>(val context : Context):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val inflater:LayoutInflater = LayoutInflater.from(context)

    override abstract fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder

    override abstract fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int)

    override abstract fun getItemCount(): Int

    override fun getItemViewType(position: Int): Int =0

    override fun getItemId(position: Int): Long =position.toLong()

    //自定义点击事件
     var itemClickListener :OnItemClickListener? = null
    fun setOnItemClickListener(listener:OnItemClickListener) :Unit{
        this.itemClickListener = listener
    }
     var itemLongClickListener :OnItemLongClickListener? = null
    fun setOnItemLongClickListener(listener : OnItemLongClickListener){
        this.itemLongClickListener = listener
    }

    interface OnItemClickListener{
        fun onItemClick(view: View, position: Int)
    }

    interface OnItemLongClickListener{
        fun onItemLongClickListener(view: View, position: Int)
    }

}