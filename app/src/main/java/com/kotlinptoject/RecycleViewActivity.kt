package com.kotlinptoject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.adapter.RecycleVIewLinearAdapter
import com.adapter.RecycleVIewLinearAdapter.OnItemClickListener
import com.data.RecycleInfo
import kotlinx.android.synthetic.main.activity_recycle_view.*
import org.jetbrains.anko.toast

class RecycleViewActivity : AppCompatActivity() {
    //集合初始化和赋值
     val recycleInfos : MutableList<RecycleInfo> = mutableListOf();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)
        rv_recycle.layoutManager = LinearLayoutManager(this)
        RecycleInfo("你好")
        recycleInfos.add( RecycleInfo("你好"))
        recycleInfos.add( RecycleInfo("他好"))
        recycleInfos.add( RecycleInfo("大家好"))
        recycleInfos.add( RecycleInfo("上午好"))
        recycleInfos.add( RecycleInfo("下午好"))
        var recycleVIewLinearAdapter = RecycleVIewLinearAdapter(this, recycleInfos)
        rv_recycle.adapter = recycleVIewLinearAdapter
        rv_recycle.itemAnimator = DefaultItemAnimator()
        recycleVIewLinearAdapter!!.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                var linearLayout = view as LinearLayout
                var tv_title = linearLayout.findViewById<TextView>(R.id.tv_title)
                toast("选的是${tv_title.text}")
            }
        })
    }
}