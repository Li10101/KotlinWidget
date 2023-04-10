package com.kotlinptoject

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.data.GoodsInfo

class ImagePagerAdapter(private val context:Context,private val goodsInfos: MutableList<GoodsInfo>) :PagerAdapter() {

    private val views = mutableListOf<ImageView>()

    init {
        for (item in goodsInfos){
            val view = ImageView(context)
            view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            view.setImageResource(item.pic)
            view.scaleType = ImageView.ScaleType.CENTER
            views.add(view)
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(views[position])
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {

        return view === `object`
    }

    override fun getCount(): Int {
        return views.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container.addView(views[position])
        return views[position]
    }

    override fun getPageTitle(position: Int): CharSequence? = goodsInfos[position].name
}