package com.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.data.RecycleInfo
import com.kotlinptoject.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_recycler_linear.*

class RecycleStaggerAdapter(context: Context,private val infos:MutableList<RecycleInfo>) :RecycleBaseAdapter<RecyclerView.ViewHolder>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var inflate = inflater.inflate(R.layout.item_recycler_linear, parent, false)
        return ItemHolder(inflate)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemHolder).bind(infos[position])
        (holder as ItemHolder).ll_item.setOnClickListener{v->
            itemClickListener!!.onItemClick(v,position)

        }

    }

    override fun getItemCount(): Int = infos.size
    class ItemHolder(override val containerView: View?):RecyclerView.ViewHolder(containerView!!)
        ,LayoutContainer{
        fun bind(item:RecycleInfo){
            var title = item.title
            tv_title.text = item.title
        }
    }
}