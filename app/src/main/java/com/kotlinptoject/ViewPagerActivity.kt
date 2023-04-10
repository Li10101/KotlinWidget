package com.kotlinptoject

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import androidx.viewpager.widget.ViewPager
import com.data.GoodsInfo
import kotlinx.android.synthetic.main.activity_view_pager.*
import org.jetbrains.anko.toast

class ViewPagerActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {
    private var goodsList = GoodsInfo.defaultList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        pts_tab.setTextSize(TypedValue.COMPLEX_UNIT_SP,20f)
        pts_tab.setTextColor(Color.GREEN)
        vp_content.adapter = ImagePagerAdapter(this,goodsList)
        vp_content.currentItem = 0
        vp_content.addOnPageChangeListener(this)
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        toast("您翻到的手机品牌为：${goodsList[position].name}")
    }

    override fun onPageScrollStateChanged(state: Int) {

    }
}