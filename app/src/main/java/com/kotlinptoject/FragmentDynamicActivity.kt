package com.kotlinptoject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import com.adapter.MobilePagerAdapter
import com.data.GoodsInfo
import kotlinx.android.synthetic.main.activity_fragment_dynamic.*

class FragmentDynamicActivity : AppCompatActivity() {
    private var goodsInfos : MutableList<GoodsInfo> = GoodsInfo.defaultList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_dynamic)
        pts_tab.setTextSize(TypedValue.COMPLEX_UNIT_SP,20f)
        //碎片适配器需要传入碎片管理器对象supportFragmentManager
        vp_content.adapter = MobilePagerAdapter(supportFragmentManager,goodsInfos)
        vp_content.currentItem = 0
    }
}