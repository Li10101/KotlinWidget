package com.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.data.GoodsInfo
import com.fragment.DynamicFragment

class MobilePagerAdapter(fm:FragmentManager,private val goodsInfos:MutableList<GoodsInfo>): FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int = goodsInfos.size

    override fun getItem(position: Int): Fragment {
        val item = goodsInfos[position]
        return DynamicFragment.newInstance(position,item.pic,item.desc,item.price)
    }

    override fun getPageTitle(position: Int): CharSequence? = goodsInfos[position].name
}