package com.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.data.RecycleInfo
import com.kotlinptoject.R

class RecycleVIewLinearAdapter(private val context:Context, private val infos: MutableList<RecycleInfo>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val recycleInfos = infos;
    val inflater :LayoutInflater = LayoutInflater.from(context)
    override fun getItemCount(): Int = recycleInfos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflate = inflater.inflate(R.layout.item_recycler_linear, parent,false)
        return ItemHolder(inflate)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemHolder = holder as ItemHolder
        itemHolder.tv_title.text = infos.get(position).title
    }
   inner class ItemHolder(view :View) : RecyclerView.ViewHolder(view) {
       var ll_item = view.findViewById<LinearLayout>(R.id.ll_item)
       var tv_title = view.findViewById<TextView>(R.id.tv_title)

   }

    //自定义点击事件
    private var itemClickListener :OnItemClickListener? = null
    fun setOnItemClickListener(listener:OnItemClickListener){
        this.itemClickListener = listener
    }
    private var itemLongClickListener :OnItemLongClickListener? = null
    fun setOnItemLongClickListener(listener : OnItemLongClickListener){
        this.itemLongClickListener = listener
    }

    interface OnItemClickListener{
        fun onItemClick(view:View,position: Int)
    }

    interface OnItemLongClickListener{
        fun onItemLongClickListener(view: View,position: Int)
    }

}